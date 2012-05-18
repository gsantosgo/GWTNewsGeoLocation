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

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.uem.geolocation.client.services.GeonamesService;
import es.uem.geolocation.server.cache.GeonamesSearchServiceImpl;
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
	private GeonamesSearchServiceImpl geonamesSearch;  

	/**
	 * Constructor 
	 */
	public GeonamesServiceImpl() {
		geonamesSearch = new GeonamesSearchServiceImpl(2, TimeUnit.DAYS, 1000);
	}

	/**
	 * Toponym search criteria 
	 */
	public List<Toponym> toponymSearchCriteria(String placeName) {				
		List<Toponym> toponymList = new ArrayList<Toponym>();
		try {			
			toponymList = geonamesSearch.search(placeName); 			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return toponymList;
	}
}
