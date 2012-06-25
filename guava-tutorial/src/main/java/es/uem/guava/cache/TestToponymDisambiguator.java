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

package es.uem.guava.cache;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.geonames.Toponym;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * Test Toponym Disambiguator 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class TestToponymDisambiguator {
	protected static PersonSearchServiceImpl personSearchServiceImpl;
	protected static GeonamesSearchServiceImpl geonamesSearchServiceImpl;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		personSearchServiceImpl = new PersonSearchServiceImpl();
		geonamesSearchServiceImpl = new GeonamesSearchServiceImpl(2, TimeUnit.DAYS, 1000); 
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
				
		List<String> hola = personSearchServiceImpl.search("hola"); 
		
		List<String> hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());		
		
		hola = personSearchServiceImpl.search("hola"); 
		
		hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());

		hola = personSearchServiceImpl.search("hola"); 
		
		hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());	
		
		
		
		List<es.uem.guava.cache.Toponym> list = geonamesSearchServiceImpl.search("Cataluña");
		list = geonamesSearchServiceImpl.search("Protección");
		System.out.println("List " + list.size());
		list = geonamesSearchServiceImpl.search("Cataluña");
		System.out.println("List " + list.size());
		list = geonamesSearchServiceImpl.search("Mallorca");
		System.out.println("List " + list.size());


		list = geonamesSearchServiceImpl.search("Protección");
		System.out.println("List " + list.size());
		list = geonamesSearchServiceImpl.search("Cataluña");
		System.out.println("List " + list.size());
		list = geonamesSearchServiceImpl.search("Mallorca");
		System.out.println("List " + list.size());
		 
	}

}
