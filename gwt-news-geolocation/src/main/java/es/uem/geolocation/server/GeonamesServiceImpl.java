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

package es.uem.geolocation.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.services.GeonamesService;
import es.uem.geolocation.geonames.ToponymDisambiguator;
import es.uem.geolocation.server.cache.GeonamesSearchServiceImpl;
import es.uem.geolocation.server.cache.SearchService;
import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;
import es.uem.geolocation.shared.Toponym;

/**
 * 
 * Geonames Service Implementation
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */

@SuppressWarnings("serial")
public class GeonamesServiceImpl extends RemoteServiceServlet implements
		GeonamesService {	
	private ToponymDisambiguator toponymDisambiguator;  

	/**
	 * Constructor 
	 */
	public GeonamesServiceImpl() {				 
	}
	
	
	@Override
	public void init() throws ServletException {
		SearchService<List<Toponym>> geonamesSearch = new GeonamesSearchServiceImpl(2, TimeUnit.DAYS, 1000);
		toponymDisambiguator = new ToponymDisambiguator(geonamesSearch);
	}
	

	/**
	 * Toponym search criteria 
	 */
	public List<Toponym> toponymSearchCriteria(String placeName) {				
		List<Toponym> toponymList = new ArrayList<Toponym>();
		try {			
			// OJO!! Arreglarlo 
			//toponymList = geonamesSearch.search(placeName); 			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return toponymList;
	}
	
	/**
	 * Toponym search criteria
	 */
	public List<NewMap> toponymSearchCriteria(List<Article> articles) {
		List<NewMap>  result = new ArrayList<NewMap>(); 
			
		List<Toponym> categoriesToponymList = null;  
		List<Toponym> headlineDescriptionToponymList = null;
		
		for (Article article : articles) {		
			NewMap newMap = new NewMap();
			
			ArrayList<Article> newArticles = new ArrayList<Article>(); 
			newArticles.add(article);
			newMap.setArticles(newArticles);										

			
			List<String> categoriesLocations = article.getCategoriesLocations();			
			List<String> headlineDescriptionLocations = article.getHeadlineDescriptionLocations();			
			
			categoriesToponymList = new ArrayList<Toponym>();			
			headlineDescriptionToponymList = new ArrayList<Toponym>();
			

			// Categories =====
			if (categoriesLocations != null && 
				categoriesLocations.size() > 0) {	
				
				for (String categoryPlaceName : categoriesLocations) {
					try {						
						// OJO!!		
						// Arreglarlo
						//categoriesToponymList = geonamesSearch.search(categoryPlaceName);
												
					} catch (Exception e) {			
						e.printStackTrace();
					}														
				}				
				
				if (categoriesToponymList.size() > 0) {					 
					newMap.setLatitude(categoriesToponymList.get(0).getLatitude()); 
					newMap.setLongitude(categoriesToponymList.get(0).getLongitude());
					newMap.setPlacename(categoriesToponymList.get(0).getName());
					result.add(newMap); 
					
					continue; 
				}
			} 
			
			// HeadlineDescription =====
			if (headlineDescriptionLocations != null && 
				headlineDescriptionLocations.size() > 0) {				
				for (String headlineDecrpiptionPlaceName : headlineDescriptionLocations) {					
					try {			
						// OJO!! Arreglarlo 
						//headlineDescriptionToponymList = geonamesSearch.search(headlineDecrpiptionPlaceName); 			
					} catch (Exception e) {			
						e.printStackTrace();
					}									
				}				
				
				if (headlineDescriptionToponymList.size() > 0) {					 
					newMap.setLatitude(headlineDescriptionToponymList.get(0).getLatitude()); 
					newMap.setLongitude(headlineDescriptionToponymList.get(0).getLongitude());
					newMap.setPlacename(headlineDescriptionToponymList.get(0).getName());
					result.add(newMap);
					
					continue; 
				}				
			}					
		
			result.add(newMap);			
		}
				
		return result; 
	}
}
