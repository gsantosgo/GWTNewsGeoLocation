package es.uem.geonames;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;

import es.uem.geonames.model.ContinentInfo;
import es.uem.geonames.model.ContinentInfos;
import es.uem.geonames.model.CountryInfo;
import es.uem.geonames.model.CountryInfos;

public class Main {

	/**
	 * 
	 * Main program 
	 * 
	 * @param args Arguments 
	 */
	public static void main(String args[]) {
		
		String inputFileNamePath = "src/main/resources/countryinfo.xml";
		Preconditions.checkNotNull(inputFileNamePath,"Input filename should NOT be NULL");
		File inputFile = new File(inputFileNamePath);

		Preconditions.checkArgument(inputFile.exists(),"File does not exist: %s", inputFile);
		
		
		
		Stopwatch stopwatch = new Stopwatch(); 
		stopwatch.start(); 
		
		XStream xstream = new XStream();
		xstream.alias("geonames", CountryInfos.class);
		xstream.alias("country", CountryInfo.class);
		xstream.addImplicitCollection(CountryInfos.class, "items");
		
		CountryInfos countryInfos = (CountryInfos) xstream.fromXML(inputFile);
		
		/*
		for (CountryInfo countryInfo : countryInfos.getContent()) {
			System.out.println(countryInfo);
		}*/ 
		stopwatch.stop();
		System.out.println("Countries :" + countryInfos.getContent().size());
		System.out.println(String.format(
				"Complete process. Elapsed time %d sec, %d msec.",
				stopwatch.elapsedTime(TimeUnit.SECONDS),
				stopwatch.elapsedTime(TimeUnit.MILLISECONDS)));
				System.out.println("");

/*		for (CountryInfo countryInfo : countryInfos.getContent()) {
			System.out.println(countryInfo.toString());
		}*/
	
		Map<String, CountryInfo> mapCountry = new HashMap<String, CountryInfo>();				
		List<CountryInfo> listCountryInfos = countryInfos.getContent(); 
		if (listCountryInfos != null && listCountryInfos.size() > 0) { 
			for (CountryInfo countryInfo : listCountryInfos) {
				mapCountry.put(countryInfo.getCountryName(), countryInfo); 
			}
		}		
		
		
		Map<String, CountryInfo> filterCountryIsoAlpha2 = Maps.filterValues(mapCountry, new ShouldIsoAlpha2Predicate("GB"));		
		System.out.println(filterCountryIsoAlpha2);
		Map<String, CountryInfo> filterCountryFipsCode = Maps.filterValues(mapCountry, new ShouldFipsCodePredicate("UK"));		
		System.out.println(filterCountryFipsCode);		
		Map<String, CountryInfo> filterCountryIsoAlpha3 = Maps.filterValues(mapCountry, new ShouldIsoAlpha3Predicate("GBR"));		
		System.out.println(filterCountryIsoAlpha3);
		
		
	}
}
