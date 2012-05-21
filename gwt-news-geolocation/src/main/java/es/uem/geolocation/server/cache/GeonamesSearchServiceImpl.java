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

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.teklabs.gwt.i18n.client.LocaleFactory;
import com.teklabs.gwt.i18n.server.LocaleProxy;

import es.uem.geolocation.client.Constant;
import es.uem.geolocation.server.AppConstants;
import es.uem.geolocation.shared.Toponym;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.geonames.FeatureClass;
import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

/**
 * 
 * Geonames Search Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
public class GeonamesSearchServiceImpl implements SearchService<List<Toponym>> {
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
		
		// Proxy Configuration 
		if (appConstants.isProxy().trim().toLowerCase().equals("true")) {
			System.setProperty("http.proxyHost", "10.14.79.204");
			System.setProperty("http.proxyPort", "8080");
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
					public List<Toponym> load(String queryKey) throws Exception {						
						List<Toponym> toponymList = new ArrayList<Toponym>();
						ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
						searchCriteria.setLanguage(Constant.DEFAULT_LANGUAGE);
						searchCriteria.setNameEquals(queryKey);
						searchCriteria.setStartRow(0);
						searchCriteria.setStyle(Style.LONG); // Importante
						
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

	public List<Toponym> search(String query) throws Exception {
		return cache.get(query);
	}

	public Cache<String, List<Toponym>> getCache() {
		return cache;
	}
}