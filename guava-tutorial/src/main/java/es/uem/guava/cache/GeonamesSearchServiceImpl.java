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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;


/**
 * 
 * Geonames Search Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class GeonamesSearchServiceImpl implements SearchService<List<Toponym>> {	
	protected LoadingCache<String, List<Toponym>> cache;
			
	/** 
	 * 
	 * Constructor 
	 *   
	 * @param duration the duration
	 * @param timeUnit the time unit 
	 * @param size the cache size
	 */
	public GeonamesSearchServiceImpl(long duration, TimeUnit timeUnit, long size) {
		buildCache(duration, timeUnit, size);		
	}

	/**
	 * 
	 * Build cache 
	 *   
	 * @param duration the duration
	 * @param timeUnit the time unit 
	 * @param size the cache size
	 */
	private void buildCache(long duration, TimeUnit timeUnit, long size) {

		cache = CacheBuilder.newBuilder()								
				.expireAfterWrite(duration, timeUnit).maximumSize(size)
				// .refreshAfterWrite(duration, unit)
				.build(new CacheLoader<String, List<Toponym>>() {								
					@Override
					public List<Toponym> load(String queryPlaceName) throws Exception {
						System.out.println("queryKey" + queryPlaceName);
						List<Toponym> toponymList = Lists.newArrayList();
						ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
						/*
						 * OJO!!
						searchCriteria.setFeatureClass(FeatureClass.A);
						searchCriteria.setFeatureClass(FeatureClass.H);
						searchCriteria.setFeatureClass(FeatureClass.L);
						searchCriteria.setFeatureClass(FeatureClass.P);
						searchCriteria.setFeatureClass(FeatureClass.T);
						searchCriteria.setFeatureClass(FeatureClass.V);*/
						searchCriteria.setLanguage("es");
						searchCriteria.setNameEquals(queryPlaceName);
						
						// 11.06.2012
						// Que el nombre comienzo
						searchCriteria.setNameStartsWith(queryPlaceName);
						searchCriteria.setStartRow(0); // Limit 100 
						searchCriteria.setMaxRows(200); 
						searchCriteria.setStyle(Style.LONG); // Importante
												
						WebService.setConnectTimeOut(10000); 
						WebService.setUserName("gsantosgo");
						
						ToponymSearchResult searchResult = WebService
								.search(searchCriteria);
						for (org.geonames.Toponym toponym : searchResult
								.getToponyms()) {
							Toponym newToponym = new Toponym();
							newToponym.setGeoNameId(toponym.getGeoNameId());
							newToponym.setName(toponym.getName());
							newToponym.setContinentCode(toponym
									.getContinentCode());
							newToponym.setCountryCode(toponym.getCountryCode());
							newToponym.setCountryName(toponym.getCountryName());
							newToponym.setAlternateNames(toponym
									.getAlternateNames());
							newToponym.setFeatureCode(toponym.getFeatureCode());
							newToponym.setFeatureCodeName(toponym
									.getFeatureCodeName());
							newToponym.setFeatureClass(toponym
									.getFeatureClass().name());
							newToponym.setFeatureClassName(toponym
									.getFeatureClassName());
							newToponym.setLatitude(toponym.getLatitude());
							newToponym.setLongitude(toponym.getLongitude());
							newToponym.setElevation(toponym.getElevation());
							newToponym.setPopulation(toponym.getPopulation());

							toponymList.add(newToponym);
						}
																						
						
						return toponymList;
					}
				});
	}


	/**
	 * Place name search 
	 */	
	public List<Toponym> search(String queryPlaceName) throws Exception {
		return cache.getUnchecked(queryPlaceName);
	}

	
	public Cache<String, List<Toponym>> getCache() {
		return cache;
	}
}
