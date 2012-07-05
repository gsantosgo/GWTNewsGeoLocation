/* Copyright (c) 2012 Guillermo Santos 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.uem.geolocation.geonames;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import es.uem.geolocation.shared.ToponymCountry;

/**
 * Load Cache 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class LoadCache {	
	final static Logger logger = LoggerFactory.getLogger(LoadCache.class);	
	public static Map<String, String> mapAbbreviations = Maps.newHashMap(); 
	public static Map<String, ToponymCountry> mapContinents = Maps.newHashMap();
	public static Map<String, ToponymCountry> mapCountries = Maps.newHashMap();		 	
	
	
	// Initialize continents, countries 
	static {	
		mapAbbreviations = Maps.newHashMapWithExpectedSize(10);
		mapContinents = Maps.newHashMapWithExpectedSize(7);
		mapCountries = Maps.newHashMapWithExpectedSize(300);
 		
		// Abbreviations ======================================================== 
		String abbreviationsFileName = "abbreviations.xml"; 		
		Preconditions.checkNotNull(abbreviationsFileName,
				"Input filename should NOT be NULL");
		File abbreviationsInputFile = new File(new LoadCache()
				.getClass().getResource(abbreviationsFileName).getFile());
		Preconditions.checkArgument(abbreviationsInputFile.exists(),
				"File does not exist: %s", abbreviationsInputFile);
				
		SAXBuilder parserAbbreviations = new SAXBuilder();
		Document docAbbreviations = null;  
		try {
			docAbbreviations = parserAbbreviations.build(abbreviationsInputFile);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Preconditions.checkNotNull(docAbbreviations, "Error en documento XML" + abbreviationsFileName);		
		Element rootAbbreviations = docAbbreviations.getRootElement();	
		for (Object obj : rootAbbreviations.getChildren("geoname")) {						
				Element element = (Element) obj;
				String id = element.getChildText("id"); 
				String name = element.getChildText("name");	
				mapAbbreviations.put(id, name);
		}
		parserAbbreviations = null; 
		docAbbreviations = null; 
		logger.info("Cached Abbreviations: " + mapAbbreviations.size());
		
		
		// Continents ========================================================
		String continentFileName = "continents.xml";
		Preconditions.checkNotNull(continentFileName,
				"Input filename should NOT be NULL");
		File continentInputFile = new File(new LoadCache()
				.getClass().getResource(continentFileName).getFile());
		Preconditions.checkArgument(continentInputFile.exists(),
				"File does not exist: %s", continentInputFile);
				
		SAXBuilder parser = new SAXBuilder();
		Document docContinent = null;  
		try {
			docContinent = parser.build(continentInputFile);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Preconditions.checkNotNull(docContinent, "Error en documento XML" + continentFileName);		
		Element root = docContinent.getRootElement();
		
		int totalResultsCount = Integer.parseInt(root.getChildText("totalResultsCount"));
		if (totalResultsCount > 0) { 
			for (Object obj : root.getChildren("geoname")) {						
				Element toponymElement = (Element) obj;
				es.uem.geolocation.shared.ToponymCountry toponym = MyWebService.getToponymContinentCountryFromElement(toponymElement);		
				mapContinents.put(toponym.getName(), toponym);
			}
		}	
		parser = null; 
		docContinent = null; 
		logger.info("Cached Continents: " + mapContinents.size());
	 				
		// Countries ====================================================================
		// CountryInfo 
		String countryInfoFileName = "countryinfo.xml";
		Preconditions.checkNotNull(countryInfoFileName, "Input filename should NOT be NULL");
		File countryInfoInputFile = new File(new LoadCache().getClass().getResource(countryInfoFileName).getFile());
		Preconditions.checkArgument(countryInfoInputFile.exists(), "File does not exist: %s", countryInfoFileName);
		
		SAXBuilder parserCountryInfo = new SAXBuilder();
		Document docCountryInfo = null; 
		try {
			docCountryInfo = parserCountryInfo.build(countryInfoInputFile);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Preconditions.checkNotNull(docCountryInfo, "Error en documento XML" + countryInfoFileName);		
		Element rootCountryInfo = docCountryInfo.getRootElement();
			
		Map<Integer, ToponymCountry> mapCountryInfoTemp = Maps.newHashMap(); 
		for (Object obj : rootCountryInfo.getChildren("country")) {						
			Element toponymElement = (Element) obj;
			es.uem.geolocation.shared.ToponymCountry toponym = MyWebService.getToponymCountryInfoFromElement(toponymElement);
			mapCountryInfoTemp.put(toponym.getGeoNameId(), toponym);  			 		
		}		
		parserCountryInfo = null; 
		docCountryInfo = null; 
		logger.info("Cached Map CountryInfo (Temp): " + mapCountryInfoTemp.size());
		

		// Countries ========================================================
		String countriesFileName = "countries.xml";
		Preconditions.checkNotNull(countriesFileName, "Input filename should NOT be NULL");
		File countriesInputFile = new File(new LoadCache().getClass().getResource(countriesFileName).getFile());
		Preconditions.checkArgument(countriesInputFile.exists(),"File does not exist: %s", countriesInputFile);
				
		SAXBuilder parserCountries = new SAXBuilder();
		Document docCountries = null;
		try {
			docCountries = parserCountries.build(countriesInputFile);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Preconditions.checkNotNull(docCountries, "Error en documento XML" + countriesFileName);		
		Element rootCountries = docCountries.getRootElement();
		
		totalResultsCount = Integer.parseInt(rootCountries.getChildText("totalResultsCount"));
		if (totalResultsCount > 0) { 
			for (Object obj : rootCountries.getChildren("geoname")) {						
				Element toponymElement = (Element) obj;
				es.uem.geolocation.shared.ToponymCountry toponym = MyWebService.getToponymContinentCountryFromElement(toponymElement);				
				
				Integer geoNameId = toponym.getGeoNameId();   
				ToponymCountry toponymCountryInfo = mapCountryInfoTemp.get(geoNameId);
				if (toponymCountryInfo != null) { 
					toponym.setIsoAlpha2(toponymCountryInfo.getIsoAlpha2());
					toponym.setIsoNumeric(toponymCountryInfo.getIsoNumeric()); 
					toponym.setIsoAlpha3(toponymCountryInfo.getIsoAlpha3());
					toponym.setFipsCode(toponymCountryInfo.getFipsCode()); 
					toponym.setCapital(toponymCountryInfo.getCapital()); 
					toponym.setContinentName(toponymCountryInfo.getContinentName());
					toponym.setAreaInSqKm(toponymCountryInfo.getAreaInSqKm());
					toponym.setCurrencyCode(toponymCountryInfo.getCurrencyCode());
					toponym.setLanguages(toponymCountryInfo.getLanguages());
									
				}						
				else {
					logger.info("No CountryInfo for " + toponymCountryInfo);
				}
				mapCountries.put(toponym.getName(), toponym);
			}
		}
		
		if (mapCountryInfoTemp != null) {
			mapCountryInfoTemp.clear();
			mapCountryInfoTemp = null; 
		}
		parserCountries = null; 
		docCountries = null; 
		logger.info("Cached Countries: " + mapCountries.size());		
	}
	
	/**
	 * Constructor 
	 */	
	public LoadCache() {		
	}
}
