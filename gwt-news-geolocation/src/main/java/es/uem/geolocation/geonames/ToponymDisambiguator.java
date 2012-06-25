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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import es.uem.geolocation.geonames.predicate.ExactAlternateNamesPredicate;
import es.uem.geolocation.geonames.predicate.ExactCountryCodePredicate;
import es.uem.geolocation.geonames.predicate.ExactFipsCodePredicate;
import es.uem.geolocation.geonames.predicate.ExactIsoAlpha2Predicate;
import es.uem.geolocation.geonames.predicate.ExactIsoAlpha3Predicate;
import es.uem.geolocation.geonames.predicate.ExactNamePredicate;
import es.uem.geolocation.server.cache.GeonamesSearchServiceImpl;
import es.uem.geolocation.server.cache.SearchService;
import es.uem.geolocation.shared.Toponym;
import es.uem.geolocation.shared.ToponymCountry;

/**
 * 
 * Toponym (Place names) Disambiguator
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class ToponymDisambiguator {		
	final static Logger logger = LoggerFactory.getLogger(ToponymDisambiguator.class);
	public static Map<String, String> mapAbbreviations = null;
	public static Map<String, ToponymCountry> mapContinents = null;
	public static Map<String, ToponymCountry> mapCountries = null;		 	
	GeonamesSearchServiceImpl geonamesSearch = new GeonamesSearchServiceImpl(2, TimeUnit.DAYS, 1000); 
	// Initialize continents, countries 
	static {	
		mapAbbreviations = Maps.newHashMapWithExpectedSize(10);
		mapContinents = Maps.newHashMapWithExpectedSize(7);
		mapCountries = Maps.newHashMapWithExpectedSize(300);
 		
		// Abbreviations ======================================================== 
		String abbreviationsFileName = "abbreviations.xml"; 		
		Preconditions.checkNotNull(abbreviationsFileName,
				"Input filename should NOT be NULL");
		File abbreviationsInputFile = new File(new ToponymDisambiguator()
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
		logger.info("Cached Continents: " + mapAbbreviations.size());
		
		
		// Continents ========================================================
		String continentFileName = "continents.xml";
		Preconditions.checkNotNull(continentFileName,
				"Input filename should NOT be NULL");
		File continentInputFile = new File(new ToponymDisambiguator()
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
		File countryInfoInputFile = new File(new ToponymDisambiguator().getClass().getResource(countryInfoFileName).getFile());
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
		File countriesInputFile = new File(new ToponymDisambiguator().getClass().getResource(countriesFileName).getFile());
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
	public ToponymDisambiguator() {		
	}
	/**
	 * Toponym Disambiguation  
	 * 
	 * @param placeNamesList the List of place names 
	 * @return 
	 */
	public Map<String,Toponym> getToponymDisambiguation(List<String> placeNamesList) {
		logger.info("List of place names: " + placeNamesList); 
		placeNamesList = translateAbbreviations(placeNamesList); 
		logger.info("Traslation List of place names (Abbreviations): " + placeNamesList);
		
		Map<String,Toponym> resultToponyms = Maps.newHashMap(); 	
		Map<String,List<Toponym>> placeNames = extractPlaceNames(placeNamesList);
		System.out.println("Size placeNames: " + placeNames.size());
		Map<ToponymCountry,List<Toponym>> countriesMap = Maps.newHashMap();				
				
		for (Iterator<String> iteratorPlaceNames = placeNames.keySet().iterator();iteratorPlaceNames.hasNext();) {
			String placeNameKey = iteratorPlaceNames.next();
			List<Toponym> list = placeNames.get(placeNameKey);			
			if (list.size() == 1) {
				
				// Only one toponym, no need disambiguation
				Toponym toponym = list.get(0); 				
				logger.info("Found unique toponym:" + toponym.getName());
								
				// =========================================================================
				// Countries Toponym 
				ToponymCountry toponymCountrySelection = null;  
				if (toponym instanceof ToponymCountry) {
					toponymCountrySelection = (ToponymCountry)toponym; 
				}
				else {					
					String countryCode = toponym.getCountryCode();					
					if (countryCode != null && countryCode.length() == 2) { 
						// If it is a placename (not continent, not country), then return information about its country.
						Map<String, ToponymCountry> filterCountryCode = Maps.filterValues(mapCountries, new ExactCountryCodePredicate(countryCode));
						if (filterCountryCode.size() > 0) {
							List<ToponymCountry> countriesList = Lists.newArrayList(filterCountryCode.values());
							toponymCountrySelection = countriesList.get(0); 
						}
					}
				}	
								
				if (toponymCountrySelection != null) {
					boolean added = false;
					for (Toponym t : countriesMap.keySet()) {								
						if (t.getCountryCode().equals(toponymCountrySelection.getCountryCode())) {
						 
							boolean isCountry = (toponym instanceof ToponymCountry); 
							List<Toponym> tempList = countriesMap.get(t);
							for (Toponym t2 : tempList) {
								String name = t2.getName(); 
								if (isCountry && 
									(t2 instanceof ToponymCountry)) {
									added = true;
									break;
								}								
								else if (Strings.isNullOrEmpty(name)) {
									continue; 									
								}
								else if (name.equals(toponym.getName())) {
									added = true;
									break; 
								}								
							}							
							if (!added)	countriesMap.get(t).add(toponym);
							added = true;
							break;						
						}
					}
						
					if(!added) {
						List<Toponym> tempList = Lists.newArrayList(); 
						tempList.add(toponym);  
						countriesMap.put(toponymCountrySelection, list);
					}					
				}				
			}								
		}
		
		logger.info("Numero paises: " + countriesMap.size());
		// ====================================================		
		// cleanCountries 
		List<ToponymCountry> countries = Lists.newArrayList();
		for (Toponym toponym : countriesMap.keySet()) {
			List<Toponym> toponymList = countriesMap.get(toponym);
			logger.info("Place name in " + toponym.getCountryCode() + ":");
			if (toponymList.size() > 1)
				countries.add((ToponymCountry)toponym); 
			else if ((toponymList.size() == 1) && ((toponymList.get(0) instanceof ToponymCountry)))
				countries.add((ToponymCountry)toponym);
		}		
		if (countries.size() == 0)
			countries.addAll(countriesMap.keySet());
		logger.info("Using the following countries:");
		for (ToponymCountry country : countries) {
			logger.info("" + country.getName() + " " + country.getCountryCode());
		}		
				
		// ====================================================		
		for (Iterator<String> iteratorPlaceNames = placeNames.keySet().iterator();iteratorPlaceNames.hasNext();) {
			String placeNameKey = iteratorPlaceNames.next();			
			List<Toponym> toponymList = placeNames.get(placeNameKey);			
			toponymList = removeToponyms(toponymList, countries); 			
			getScore(placeNameKey, toponymList, 1);
			int size = toponymList.size();  
			if ( size == 1) {
				// Resultado 		
				resultToponyms.put(placeNameKey, toponymList.get(0)); 
			} else if (size > 1) {
				resultToponyms.put(placeNameKey, toponymList.get(0));	 			
			} else {
				// There aren't toponym
				logger.info("Not find toponyms for " + placeNameKey);
			}			
		}		
		return resultToponyms; 
	}
	
	
	/*	Checks each KafTerm to see if it is a location; if so, the possible locations are 
	 * 	retrieved from GeoNames and returned in a HashMap, with the KafTerm as key.
	 */

	/**
	 *  To each placename checks it it is a location.  
	 *   	Is it a location? Yes, the possible locations are stored in a HashMap, to each placename
	 *    					  No, there aren't locations to store. 
	 *  Extract Place Names    
	 * 
	 * @param placeNames (toponym) the List place names  
	 * @return the Map 
	 */
	public Map<String,List<Toponym>> extractPlaceNames(List<String> placeNames)  {		
		Map<String,List<Toponym>> result = Maps.newHashMap();		
		for (String placeName : placeNames) {							
			System.out.println("placeName" + placeName);
			List<Toponym> toponymList = Lists.newArrayList();
			// Find continents =====			
			Map<String, ToponymCountry> filterContinents = Maps.filterKeys(mapContinents, new ExactNamePredicate(placeName));
			if (filterContinents.size() > 0) {
				List<ToponymCountry> list = Lists.newArrayList(filterContinents.values());
				toponymList.add(list.get(0));								
			}				
			
			// Find countries =====			
			if (toponymList.size() == 0 ) {								
				Map<String, ToponymCountry> filterCountries = Maps.filterKeys(mapCountries, new ExactNamePredicate(placeName));				
				if (filterCountries.size() > 0)  {
					List<ToponymCountry> list = Lists.newArrayList(filterCountries.values());
					try {						
						toponymList.add(list.get(0));						
						// Geonames Web Services 
						// toponymList.addAll(geonamesSearch.searchCountry(list.get(0).getCountryName()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}								
				// UK (no GB) 
				else if (placeName.length() == 2 && CharMatcher.JAVA_UPPER_CASE.matchesAllOf(placeName)) {					
					// There aren't continents, search continents 				
					// ISO Alpha2 =====
					Map<String, ToponymCountry> filterCountryIsoAlpha2 = Maps.filterValues(mapCountries, new ExactIsoAlpha2Predicate(placeName));
					if (filterCountryIsoAlpha2.size() > 0) {
						List<ToponymCountry> list = Lists.newArrayList(filterCountryIsoAlpha2.values());
						try {
							toponymList.add(list.get(0));														
							// Geonames Web Services 
							// toponymList.addAll(geonamesSearch.searchCountry(list.get(0).getCountryName()));
						} catch (Exception e) {
							e.printStackTrace();
						} 																
					}
					
					// FipsCode ===== 
					if (filterCountryIsoAlpha2.size() == 0) {
						Map<String, ToponymCountry> filterCountryFipsCode = Maps.filterValues(mapCountries, new ExactFipsCodePredicate(placeName));					
						if (filterCountryFipsCode.size() > 0) {
							List<ToponymCountry> list = Lists.newArrayList(filterCountryFipsCode.values());
							try {								
								toponymList.add(list.get(0));								
								// Geonames Web Services
								// toponymList.addAll(geonamesSearch.searchCountry(list.get(0).getCountryName()));
							} catch (Exception e) {
								e.printStackTrace();
							} 																
						}												
					}					
				}
				// IsoAlpha3 USA  
				else if (placeName.length() == 3 && CharMatcher.JAVA_UPPER_CASE.matchesAllOf(placeName)) {					
					Map<String, ToponymCountry> filterCountryIsoAlpha3 = Maps.filterValues(mapCountries, new ExactIsoAlpha3Predicate(placeName));					
					if (filterCountryIsoAlpha3.size() > 0) {
						List<ToponymCountry> list = Lists.newArrayList(filterCountryIsoAlpha3.values());
						try {
							toponymList.add(list.get(0));							
							// Geonames
							// toponymList.addAll(geonamesSearch.searchCountry(list.get(0).getCountryName()));
						} catch (Exception e) {
								e.printStackTrace();
						} 																
					}
				}				
				// OJO!! 13.06.2012
				// performance 
				// alternateNames
				else {
					Map<String, ToponymCountry> filterAlternateNamesCountries = Maps.filterValues(mapCountries, new ExactAlternateNamesPredicate(placeName));				
					if (filterAlternateNamesCountries.size() > 0)  {
						List<ToponymCountry> list = Lists.newArrayList(filterAlternateNamesCountries.values());
						try {						
							toponymList.add(list.get(0));						
							// Geonames Web Services 
							// toponymList.addAll(geonamesSearch.searchCountry(list.get(0).getCountryName()));
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 						
				}
			}					
			
			// Find locations =====
			if(toponymList.size() == 0) {				
				// There aren't countries, search locations								
				// name = 'name', name REGEXP, ansiname REGEXP, alternatenames REGEXP()									
				// !!OJO Exception 
				try {					
					toponymList = geonamesSearch.search(placeName);
					System.out.println("toponymList.size()==== " + toponymList.size());
				} catch (Exception e) {
					e.printStackTrace();
				} 				
			}
						
			// Are there toponym 
			if (toponymList.size() > 0) {
				System.out.println("placeName:" + placeName + "(" +toponymList.size() + ")");
				result.put(placeName, toponymList);
			}
		}		
		return result; 
	}
		
	/**
	 *  
	 * Calculate score for place name 
	 * 
	 * @param placeName the Place name 
	 * @param toponym the Toponym  
	 * @param toponymList the List of toponyms 
	 *  
	 * @return the Score 
	 */
	private double getScore(String placeName, Toponym toponym, List<Toponym> toponymList) {
		double score = 1.0;
		// continents and countries 
		if (toponym instanceof ToponymCountry) {
			score = 3.0;
		}
		// for others locations 
		else { 						
			// A, H, .. 
			String featureClass = toponym.getFeatureClass(); 			
			// ADM1, PCLI 
			String featureCode = toponym.getFeatureCode(); 
			
			if (Strings.isNullOrEmpty(featureClass) &&
			    (featureClass.equals("."))) {
				score -= .5; 				
			}
			else {		

				char featureClassC = Character.toUpperCase(featureClass.charAt(0));				
				switch (featureClassC) {
					// Administrative Boundary Features (Country, State, Region, ...)
					case 'A':
							// political entity
							if (featureCode.startsWith("PCL")) score += 1;
							// a primary administrative division of a country, such as a state in the United States 
							else if (featureCode.startsWith("ADM1")) score += 1;
							else score += .5;
							break;
							
					// Hydrographic Features (Stream, Lake, Ocean, Sea, ...)
					case 'H':
							score += .5;
							break;
							
					//  Area Features (Parks, Area, Continent (CONT),)  
					case 'L':
							if (featureCode.startsWith("CONT")) score = 3; // Continent
							else if (featureCode.startsWith("RES")) score += 1; // Nature Reserve 							
							break; 
					
					// Populated Place Features (City, Village) 
					case 'P': 				 
							if (featureCode.endsWith("A") || 	// A..A4 (Administrative Division) 
								featureCode.endsWith("A2") || 
								featureCode.endsWith("A3") || 
								featureCode.endsWith("A4") ||
							    featureCode.endsWith("C") ||	// Capital of a political entity  
							    featureCode.endsWith("G"))		// Seat of government of a political entity
								score += 1;
							else  {												
								if (toponym.getPopulation() != null) { 
									long population = toponym.getPopulation();									
									boolean largestPopulation = true;
									for (Toponym t : toponymList) {										
										if (t.getPopulation() != null  && 
											t.getPopulation() > population) {
											score -= 1; 
											largestPopulation = false;
											break; 
										}																		
									}
									if (largestPopulation) score += .5;	
								}																
							}							
							break;
							
					// Road / Railroad Features (Road, RailRoad) 
					case 'R': 
							score = score - .5; 						
							break;
							
					// Spot Features (Spots, Building, Farm)  
					case 'S': 
						//some spots are ok (airports, dikes, bridges, dams), others not (hotels, campsites, etc.)
						if (!(featureCode.startsWith("AIR") ||  // Airports 
							  featureCode.startsWith("BDG") ||  // Bridge
							  featureCode.startsWith("CAVE") || // an underground passageway or chamber, or cavity on the side of a cliff
							  featureCode.startsWith("DAM") ||  //
							  featureCode.startsWith("DIKE") || // an earth or stone embankment usually constructed for flood or stream control
							  featureCode.startsWith("LNDF") || // a place for trash and garbage disposal in which the waste is buried between layers of earth to build up low-lying land
							  featureCode.startsWith("PIER") || // a structure built out into navigable water on piles providing berthing for ships and recreation						  
							  featureCode.startsWith("RSTN") || // railroad station 
							  featureCode.startsWith("SQR") ||  // a broad, open, public area near the center of a town or city
							  featureCode.startsWith("TOWR")))  // a high conspicuous structure, typically much higher than its diameter
							score = score - .5;
						break;
						
					// Hypsographic Features (Mountain, Hill, Rock, ..) 
					case 'T':
						score += .5;	
						break; 
					
					// Undersea Features (Undersea) 
					case 'U':	
						break; 
	
					// Vegetation Features (Forest, Heath) 
					case 'V':
						score += .5;
						break; 		
					
					default: 
						break; 										
				}		
				logger.debug(toponym.getName() + " in " + toponym.getContinentCode() + ":" + featureClassC + ", " + score);				
			}						
		}
		return score; 
	}
	
	
	/**
	 * Calculate toponyms list score based on the combination of the feature code (Geonames database) and 
	 * the population size, and remove toponym below highScore
	 * 
	 * In this current algorithm, the score ranges between 0 and 3 
	 * 
	 *  Toponym   		Score
	 *  -------- 		-----
	 * 	continent 		(3)
	 *  countries 		(3) 
	 *  states 	  		(2) 
	 *  regions   		(2)
	 *  capitals  		(2)
	 *  nature reserve 	(2) 
	 *  ....
	 *  
	 *  small city 		(1)  
	 *  villages  		(1)
	 *   
	 *  road			(0.5) 
	 *  
	 *   
	 *   
	 * 
	 * @param placeName the Place name 
	 * @param toponymList the Toponym List of a place name  
	 * @param threshold If you specify a threshold, only toponyms list with a higher score are returned. 
	 *   
	 */
	public void getScore(String placeName, List<Toponym> toponymList, int threshold) {		
		double highScore = 0.0;
		// Calculate score 
		for (Toponym toponym : toponymList) {
			double score = getScore(placeName, toponym, toponymList);
			toponym.setDisambiguationScore(score);
			if (score > highScore) highScore = score; 
		}

		// Remove toponyms below highScore  
		for(Iterator<Toponym> it = 	toponymList.iterator(); it.hasNext();) {
			Toponym toponym = it.next(); 
			if (toponym.getDisambiguationScore() < highScore) 
				it.remove(); 
			else if ((threshold > 0) && 
					 (toponym.getDisambiguationScore() < threshold)) {
				it.remove(); 
			}
		}				
	}
	

	
	/**
	 * Remove all toponym from toponyms list that are nowhere near any of the given list of countries  and
	 * sorts the others in order of relevance by proximity. Countries, or locations within countries,
	 * come first; then those near the border; and finally those on the same latitude or longitude.
	 * 
	 * @param toponymList the Toponym list 
	 * @param countries The countries, continent   
	 * @return the Toponym list
	 */
	public List<Toponym> removeToponyms(List<Toponym> toponymList, List<ToponymCountry> countries) {
		List<Toponym> resultToponymList = Lists.newArrayList(); 
		final int distance = 10;

		// Aren't there countries? 
		if(countries.isEmpty()) {
			return toponymList; 
		}
		else {
		// Are there countries? 			
			for (Iterator<Toponym> iterator = toponymList.iterator(); iterator.hasNext(); ) {
				Toponym toponym = iterator.next();				
				if (toponym.getCountryCode().length() == 0) {
					continue; 
				}				
				for (Toponym country : countries) {
					// Same Country Code.  
					// if the location is in one of the countries, return true;					
					if (toponym.getCountryCode().equalsIgnoreCase(country.getCountryCode())) {
						resultToponymList.add(toponym);
						iterator.remove();
						break; 
					}
				}
			}
						
			for (Iterator<Toponym> iterator = toponymList.iterator(); iterator.hasNext(); ) {				
				Toponym toponym = iterator.next();
				if (toponym instanceof ToponymCountry) {					
					resultToponymList.add(toponym);
					continue; 					
				}
								
				for (ToponymCountry country : countries) {					
					// OJO!! Cuidado 
					double latitude = toponym.getLatitude();
					double longitude = toponym.getLongitude(); 
					
					double west = country.getWest(); 
					double east = country.getEast();
					double south = country.getSouth(); 
					double north = country.getNorth(); 
					
					
					if (isToponymInBordersLongitude(longitude, west, east) &&
						isToponymInBordersLatitude(latitude, north, south)) {
						resultToponymList.add(toponym); 
					} 
					else if ( 
								(isToponymInBordersLongitude(longitude, west, east) && isNearLatitude(latitude, north, south, distance)) || 
								(isNearLongitude(longitude, west, east, distance) && isToponymInBordersLatitude(latitude, north, south)) ||
								(isNearLongitude(longitude, west, east, distance) && isNearLatitude(latitude, north, south, distance))
							) {							 
						resultToponymList.add(toponym);							 
					}
				}
			}					
		}
		
		return resultToponymList; 
	}
	
	/**
	 * 
	 * Is Longitude in bounding box?
	 * 
	 * @param longitude the Longitude
	 * @param west the West 
	 * @param east the East 
	 * @return
	 */
	private boolean isToponymInBordersLongitude(double longitude, double west, double east) { 
		return ((west <= longitude) && (east >= longitude)); 
	}
	
	/**
	 * 
	 * Is Latitude in bounding box? 
	 * 
	 * @param latitude the Latitude 
	 * @param north the North 
	 * @param south the South 
	 * @return 
	 */

	private boolean isToponymInBordersLatitude(double latitude, double north, double south) { 
		return ((south <= latitude) && (north >= latitude)); 
	}

	
	/**
	 * 
	 * @param longitude the Longitude 
	 * @param west the West 
	 * @param east the East 
	 * @param distance the Distance 
	 * @return
	 */
	private boolean isNearLongitude(double longitude, double west, double east, int distance) {
		return (Math.abs(west - longitude) <= (distance * 2)) || (Math.abs(longitude - east) <= (distance * 2));
	}

	/**
	 * 
	 * @param latitude the Latitude
	 * @param north the North 
	 * @param south the South 
	 * @param distance the Distance 
	 * @return
	 */
	private boolean isNearLatitude(double latitude, double north, double south, int distance) {
		return  (Math.abs(south - latitude) <= distance) || (Math.abs(latitude - north) <= distance); 
	}
	
	/**
	 * If it is an abbreviations, translate  
	 * @param placeNamesList the List of place names 
	 * @return
	 */
	private List<String> translateAbbreviations(List<String> placeNamesList) {
		List<String> placeNamesListTemp = Lists.newArrayList(); 
		for (String placeName : placeNamesList) {
			if (mapAbbreviations.containsKey(placeName)) {
				placeNamesListTemp.add(mapAbbreviations.get(placeName)); 
			} 
			else {
				placeNamesListTemp.add(placeName); 
			}
		}
		return placeNamesListTemp; 
	}
}