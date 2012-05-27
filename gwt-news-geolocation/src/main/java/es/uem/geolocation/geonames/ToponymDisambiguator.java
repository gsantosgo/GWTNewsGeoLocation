package es.uem.geolocation.geonames;


import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;

import es.uem.geolocation.geonames.model.ContinentInfo;
import es.uem.geolocation.geonames.model.ContinentInfos;
import es.uem.geolocation.geonames.model.CountryInfo;
import es.uem.geolocation.geonames.model.CountryInfos;
import es.uem.geolocation.geonames.predicate.ExactFipsCodePredicate;
import es.uem.geolocation.geonames.predicate.ExactIsoAlpha3Predicate;
import es.uem.geolocation.geonames.predicate.ExactNamePredicate;
import es.uem.geolocation.server.cache.SearchService;
import es.uem.geolocation.shared.Toponym;

/**
 * 
 * Toponym (Place names) Disambiguator
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class ToponymDisambiguator {
	public static Map<String, ContinentInfo> mapContinent = null;
	public static Map<String, CountryInfo> mapCountry = null;	
	private SearchService<List<Toponym>> geonamesSearch;	

	
	// Initialize continents, countries 
	static {
		mapContinent = Maps.newHashMapWithExpectedSize(10);
		mapCountry = Maps.newHashMapWithExpectedSize(300);

		// Continents ======
		String continentFileName = "continents.xml";
		Preconditions.checkNotNull(continentFileName,
				"Input filename should NOT be NULL");
		File continentInputFile = new File(new ToponymDisambiguator()
				.getClass().getResource(continentFileName).getFile());

		Preconditions.checkArgument(continentInputFile.exists(),
				"File does not exist: %s", continentInputFile);

		XStream continentXstream = new XStream();
		continentXstream.alias("geonames", ContinentInfos.class);
		continentXstream.alias("totalResultsCount", Integer.class);
		continentXstream.alias("geoname", ContinentInfo.class);
		continentXstream.addImplicitCollection(ContinentInfos.class, "items");

		ContinentInfos continentInfos = (ContinentInfos) continentXstream
				.fromXML(continentInputFile);
		List<ContinentInfo> listContinentInfos = continentInfos.getContent();
		if (listContinentInfos != null && listContinentInfos.size() > 0) {
			for (ContinentInfo continentInfo : listContinentInfos) {
				mapContinent.put(continentInfo.getName(), continentInfo);
			}
		}

		
		// Countries ===== 				
		String countryFileName = "countryinfo.xml";
		Preconditions.checkNotNull(countryFileName, "Input filename should NOT be NULL");
		File countryInputFile = new File(new ToponymDisambiguator().getClass().getResource(countryFileName).getFile());
		Preconditions.checkArgument(continentInputFile.exists(), "File does not exist: %s", countryFileName);

		XStream countryXstream = new XStream(); 
		countryXstream.alias("geonames",CountryInfos.class); 
		countryXstream.alias("country", CountryInfo.class);
		countryXstream.addImplicitCollection(CountryInfos.class, "items");
		  
		CountryInfos countryInfos = (CountryInfos)
		countryXstream.fromXML(countryInputFile); 
		List<CountryInfo> listCountryInfos = countryInfos.getContent(); 
		if (listCountryInfos != null && listCountryInfos.size() > 0) { 
			for (CountryInfo countryInfo : listCountryInfos) {
				mapCountry.put(countryInfo.getCountryName(), countryInfo); 
			}
		}		
	}
	
	/**
	 * Constructor 
	 */
	public ToponymDisambiguator() {
		
	}
	
	/**
	 * 
	 * Constructor 
	 * 
	 * @param geonamesSearch1 Geonames search
	 */
	public ToponymDisambiguator(SearchService<List<Toponym>> geonamesSearch1) {
		this.geonamesSearch = geonamesSearch1;
	}
	
	/**
	 * Set Geonames search 
	 * @param geonamesSearch1 Geonames search 
	 */
	public void setSearchService(SearchService<List<Toponym>> geonamesSearch1) {
		this.geonamesSearch = geonamesSearch1;
	}
	
	/**
	 * Extract Place names 
	 * 
	 * @param placeNames
	 * @return
	 */
	public Map<String,List<Toponym>> extractPlaceNames(List<String> placeNames) {		
		Map<String,List<Toponym>> result = Maps.newHashMap();
		
		for (String placeName : placeNames) {				
			List<String> locations = new ArrayList<String>();
			
			// Find continents =====			
			Map<String, ContinentInfo> filterContinents = Maps.filterKeys(mapContinent, new ExactNamePredicate(placeName));
			if (filterContinents.size() > 0) {
				locations.add("continent");			
			}				
			
			// Find countries ======			
			if (locations.size() == 0 ) {
				// There aren't continents, search continents 				
				// ISO Alpha2
				Map<String, CountryInfo> filterCountryIsoAlpha2 = Maps.filterKeys(mapCountry, new ExactNamePredicate(placeName));
				if (filterCountryIsoAlpha2.size() > 0) {
					locations.add("country");
				}
				// UK (no GB) 
				else if (placeName.length() == 2 && CharMatcher.JAVA_UPPER_CASE.matchesAllOf(placeName)) {					
					Map<String, CountryInfo> filterCountryFipsCode = Maps.filterValues(mapCountry, new ExactFipsCodePredicate(placeName));					
					if (filterCountryFipsCode.size() > 0) {
						locations.add("country");
					}
				}
				// USA  
				else if (placeName.length() == 3 && CharMatcher.JAVA_UPPER_CASE.matchesAllOf(placeName)) {					
					Map<String, CountryInfo> filterCountryIsoAlpha3 = Maps.filterValues(mapCountry, new ExactIsoAlpha3Predicate(placeName));					
					if (filterCountryIsoAlpha3.size() > 0) {
						locations.add("country");
					}
				}												
			}			
			
			// Find locations ======
			if(locations.size() == 0) {
				// There aren't countries, search locations
			}
			
			if (locations.size() > 0)	
				// Are there locations?, put placeName				
				// OJO!! Falta 
				result.put(placeName, null);
		}
		
		return result; 
	}
}

