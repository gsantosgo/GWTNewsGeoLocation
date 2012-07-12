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
import java.util.Map;

import javax.servlet.ServletException;

import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.services.GeonamesService;
import es.uem.geolocation.geonames.ToponymDisambiguator;
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
	
	final static Logger logger = LoggerFactory.getLogger(GeonamesServiceImpl.class);	
	private ToponymDisambiguator toponymDisambiguator;  

	/**
	 * Constructor 
	 */
	public GeonamesServiceImpl() {				 
	}
	
	
	@Override
	public void init() throws ServletException {		
		toponymDisambiguator = new ToponymDisambiguator();
	}
	

	/**
	 * Toponym search criteria 
	 */
	public List<Toponym> toponymSearchCriteria(String placeName) {				
		List<Toponym> toponymList = Lists.newArrayList();  
		try {			
			Map<String,Toponym> toponymDisambiguatonMaps = toponymDisambiguator.getToponymDisambiguation(Lists.newArrayList(placeName));			
			if (!toponymDisambiguatonMaps.isEmpty()) {				
				Map.Entry<String, Toponym> entry = toponymDisambiguatonMaps.entrySet().iterator().next();				
				toponymList.add(entry.getValue());
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return toponymList;
	}
	
	/**
	 * Toponym search criteria
	 */
	public List<NewMap> toponymSearchCriteria(List<Article> articles, String countryCode) {
		List<NewMap>  result = Lists.newArrayList();  
			
		List<Toponym> categoriesToponymList = null;  
		List<Toponym> headlineDescriptionToponymList = null;

		logger.info("Starting the processing Named Entities Resolution.");
		for (Article article : articles) {		
			NewMap newMap = new NewMap();
			
			ArrayList<Article> newArticles = Lists.newArrayList();  
			newArticles.add(article);
			newMap.setArticles(newArticles);										

			
			List<String> categoriesLocations = article.getCategoriesLocations();			
			List<String> headlineDescriptionLocations = article.getHeadlineDescriptionLocations();
 
			
			categoriesToponymList = Lists.newArrayList();			
			headlineDescriptionToponymList = Lists.newArrayList(); 
			

			
			// HeadlineDescription =====
			if (headlineDescriptionLocations != null && !headlineDescriptionLocations.isEmpty()) {
				// Add countryCode to disambiguate toponyms
				if (!Strings.isNullOrEmpty(countryCode)) headlineDescriptionLocations.add(countryCode);
				logger.info("List of locations (HeadlineDesc): " + headlineDescriptionLocations.toString());
				Map<String,Toponym> toponymDisambiguationMaps = toponymDisambiguator.getToponymDisambiguation(headlineDescriptionLocations);
				/*Iterator<String> iterator = toponymDisambiguationMaps.keySet().iterator();
				while (iterator.hasNext()) {
					String placeName = iterator.next(); 					
					logger.debug(":::: Selected " + placeName + " " + toponymDisambiguationMaps.get(placeName));
				}*/								
				if (!toponymDisambiguationMaps.isEmpty()) {				
					Map.Entry<String, Toponym> entry = toponymDisambiguationMaps.entrySet().iterator().next();
					headlineDescriptionToponymList.add(entry.getValue()); 					
				}
				
				if (!headlineDescriptionToponymList.isEmpty()) {
					logger.info(String.format(":::: Selected HeadlineDesc : %s (%f,%f)", headlineDescriptionToponymList.get(0).getName(), headlineDescriptionToponymList.get(0).getLatitude(), headlineDescriptionToponymList.get(0).getLongitude()));					
					newMap.setLatitude(headlineDescriptionToponymList.get(0).getLatitude()); 
					newMap.setLongitude(headlineDescriptionToponymList.get(0).getLongitude());
					newMap.setPlacename(headlineDescriptionToponymList.get(0).getName());
					result.add(newMap);
					
					continue; 
				}				
			}
			
			// Categories =====
			if (categoriesLocations != null && !categoriesLocations.isEmpty()) {
				// Add countryCode to disambiguate toponyms
				if (!Strings.isNullOrEmpty(countryCode)) categoriesLocations.add(countryCode);
				logger.info("List of locations (Categories): " + categoriesLocations.toString());				
				Map<String,Toponym> toponymDisambiguationMaps = toponymDisambiguator.getToponymDisambiguation(categoriesLocations);				
				/*Iterator<String> categoriesIterator = toponymDisambiguationMaps.keySet().iterator();
				while (categoriesIterator.hasNext()) {
					String placeName = categoriesIterator.next(); 
					logger.debug(":::: Selected " + placeName + " " + toponymDisambiguationMaps.get(placeName));
				}*/				
				if (!toponymDisambiguationMaps.isEmpty()) {				
					Map.Entry<String, Toponym> entry = toponymDisambiguationMaps.entrySet().iterator().next();
					categoriesToponymList.add(entry.getValue()); 
				}
				
				// OJO!!
				if (!categoriesToponymList.isEmpty()) {					
					logger.info(String.format(":::: Selected Categories: %s (%f,%f)", categoriesToponymList.get(0).getName(), categoriesToponymList.get(0).getLatitude(), categoriesToponymList.get(0).getLongitude()));
					newMap.setLatitude(categoriesToponymList.get(0).getLatitude()); 
					newMap.setLongitude(categoriesToponymList.get(0).getLongitude());
					newMap.setPlacename(categoriesToponymList.get(0).getName());
					result.add(newMap); 
					
					continue; 
				}
			} 
			
		
			result.add(newMap);			
		}
		logger.info("End the processing Named Entities Resolution.");
				
		return result; 
	}
}
