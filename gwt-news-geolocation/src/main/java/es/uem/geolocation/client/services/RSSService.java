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

package es.uem.geolocation.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import es.uem.geolocation.shared.RSS;

/**
 * The client side stub for the RPC service.
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */

@RemoteServiceRelativePath("rss")
public interface RSSService extends RemoteService {	
	
	/**
	 * 
	 * Load Local RSS Source (Testing)
	 * 
	 * @param type the Type of News (Nacional, Internacional)
	 * @param countryCode the countryCode  
	 * @return
	 * @throws Exception
	 */
	RSS loadLocalRSSNews(String type) throws Exception;
	
	/**
	 * 
	 * Load RSS News (Remote) 
	 * @param uri the Remote URI RSS Source
	 * @param countryCode the countryCode RSS
	 * @return the RSS Source
	 * @throws Exception
	 */
	RSS loadRSSNews(String uri) throws Exception; 	
}
