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
package es.uem.geolocation.server.cache;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.teklabs.gwt.i18n.client.LocaleFactory;
import com.teklabs.gwt.i18n.server.LocaleProxy;

import es.uem.geolocation.client.Constant;
import es.uem.geolocation.server.AppConstants;
import es.uem.geolocation.shared.Toponym;

/**
 * 
 * Geonames Search Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class GeonamesSearchServiceImpl implements SearchService<List<Toponym>> {
	final static Logger logger = LoggerFactory.getLogger(GeonamesSearchServiceImpl.class);	
	protected AppConstants appConstants;	
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
		LocaleProxy.initialize();		
		appConstants = LocaleFactory.get(AppConstants.class);
		
		logger.info("Conexión con proxy: "  + appConstants.isProxy());
		// Proxy Configuration
		if (appConstants.isProxy()) {			
			System.setProperty("http.proxyHost", appConstants.proxyHostName());
			System.setProperty("http.proxyPort", ""+appConstants.proxyPort());
			logger.info(String.format("proxyHost: %s, proxyPort: %s", appConstants.proxyHostName(), ""+appConstants.proxyPort()));			
		}		
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
						logger.debug("Request Geonames Web Services Search: " + queryPlaceName);
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
						searchCriteria.setLanguage(Constant.DEFAULT_LANGUAGE);
						searchCriteria.setNameEquals(queryPlaceName);
						
						// 11.06.2012
						// Que el nombre comienzo
						searchCriteria.setNameStartsWith(queryPlaceName);
						searchCriteria.setStartRow(0); // Limit 100 
						searchCriteria.setMaxRows(200); 
						searchCriteria.setStyle(Style.LONG); // Importante
												
						WebService.setConnectTimeOut(appConstants.geonamesWebServiceConnectTimeOut()); 
						WebService.setUserName(appConstants.geonamesWebServiceUsername());
						
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
	public List<Toponym> search(String queryPlaceName)  {
		List<Toponym> toponymList = Lists.newArrayList(); 
			try {
				toponymList = cache.get(queryPlaceName);
				logger.debug(String.format("Get Cache. PlaceName: %s , Number of Toponyms: %d", queryPlaceName, toponymList.size()));				
			} catch (ExecutionException e) {
				logger.error(e.getMessage()); 
				e.printStackTrace();
			}
		return toponymList; 
	}

	
	public Cache<String, List<Toponym>> getCache() {
		return cache;
	}
}
