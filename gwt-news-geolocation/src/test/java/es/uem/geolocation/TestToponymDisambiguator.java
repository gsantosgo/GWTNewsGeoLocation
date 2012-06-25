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

package es.uem.geolocation;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;

import es.uem.geolocation.geonames.ToponymDisambiguator;
import es.uem.geolocation.server.cache.GeonamesSearchServiceImpl;
import es.uem.geolocation.shared.Toponym;
import es.uem.geolocation.shared.ToponymCountry;


/**
 * 
 * Test Toponym Disambiguator 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class TestToponymDisambiguator {
	protected static GeonamesSearchServiceImpl geonamesSearch;
	protected static ToponymDisambiguator toponymDisambiguator; 
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		 //geonamesSearch = 
		 toponymDisambiguator = new ToponymDisambiguator();
		 //toponymDisambiguator.setSearchService(geonamesSearch); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
		
	@Test 
	public void testPrueba() {
		String s = new String("hola");
		assertEquals("Resultado", s, "hola"); 
	}
	
	@Test
	public void testToponymDisambiguator() throws Exception {		 		

		/*
		List<Toponym> list = geonamesSearch.search("Cataluña");
		list = geonamesSearch.search("Protección");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Cataluña");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Mallorca");
		System.out.println("List " + list.size());


		list = geonamesSearch.search("Protección");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Cataluña");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Mallorca");
		System.out.println("List " + list.size());

		*/
		
		//List<String> placeNames = Lists.newArrayList("Asturias", "España", "Estados Unidos", "Europa", "UK", "GB", "Oceanía", "Talavera de la Reina", "Toledo");
		//List<String> placeNames = Lists.newArrayList("Valladolid", "España", "Guijo de Santa Barbara");
		
		List<String> placeNames = Lists.newArrayList("Protección", "Cataluña", "Mallorca");		
		// [fue, Zumárraga, PSE, Guipúzcoa]
		//List<String> placeNames = Lists.newArrayList("Asturias", "Talavera de la Reina", "Toledo");
/*		Map<String,List<es.uem.geolocation.shared.Toponym>> toponyms = toponymDisambiguator.extractPlaceNames(placeNames);
		System.out.println("Tamaño: " + toponyms.size());
		Iterator<String> iterator = toponyms.keySet().iterator();
		while (iterator.hasNext()) {
			String placeName = iterator.next(); 
			System.out.println("PlaceName: " + placeName + " " + toponyms.get(placeName).size() );
		}*/
		
		
		// ======= 
		Map<String,Toponym> toponymsDisambiguation = toponymDisambiguator.getToponymDisambiguation(placeNames); 
		Iterator<String> iterator2 = toponymsDisambiguation.keySet().iterator();
		while (iterator2.hasNext()) {
			String placeName = iterator2.next(); 
			System.out.println("PlaceName: " + placeName + " " + toponymsDisambiguation.get(placeName));
		}
		
		/*
		list = geonamesSearch.search("Protección");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Cataluña");
		System.out.println("List " + list.size());
		list = geonamesSearch.search("Mallorca");
		System.out.println("List " + list.size());
		*/
		
		toponymsDisambiguation = toponymDisambiguator.getToponymDisambiguation(placeNames); 
		iterator2 = toponymsDisambiguation.keySet().iterator();
		while (iterator2.hasNext()) {
			String placeName = iterator2.next(); 
			System.out.println("PlaceName: " + placeName + " " + toponymsDisambiguation.get(placeName));
		}
		
		toponymsDisambiguation = toponymDisambiguator.getToponymDisambiguation(placeNames); 
		iterator2 = toponymsDisambiguation.keySet().iterator();
		while (iterator2.hasNext()) {
			String placeName = iterator2.next(); 
			System.out.println("PlaceName: " + placeName + " " + toponymsDisambiguation.get(placeName));
		}
		
		ConcurrentMap<String, List<Toponym>> map = geonamesSearch.getCache().asMap();
		Iterator<String> aaaa = map.keySet().iterator(); 
		while (aaaa.hasNext()) {
			String key = aaaa.next(); 
			System.out.println( key + " " +  map.get(key).size());			
		}

		
		aaaa = map.keySet().iterator(); 
		while (aaaa.hasNext()) {
			String key = aaaa.next(); 
			System.out.println( key + " " +  map.get(key).size());			
		}


		toponymsDisambiguation = toponymDisambiguator.getToponymDisambiguation(placeNames); 
		iterator2 = toponymsDisambiguation.keySet().iterator();
		while (iterator2.hasNext()) {
			String placeName = iterator2.next(); 
			System.out.println("PlaceName: " + placeName + " " + toponymsDisambiguation.get(placeName));
		}
		
		aaaa = map.keySet().iterator(); 
		while (aaaa.hasNext()) {
			String key = aaaa.next(); 
			System.out.println( key + " " +  map.get(key).size());			
		}		
 
	}

}
