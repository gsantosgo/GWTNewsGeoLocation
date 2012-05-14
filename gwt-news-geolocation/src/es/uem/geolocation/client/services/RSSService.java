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

import java.util.*;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import es.uem.geolocation.shared.Article;
import es.uem.geolocation.shared.NewMap;

/**
 * The client side stub for the RPC service.
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */

@RemoteServiceRelativePath("rss")
public interface RSSService extends RemoteService {
	List<NewMap> loadGeoRSSNews();
	
	
	/**
	 * 
	 * Load RSS News  
	 * 
	 * @param uri	URI  
	 * @return List of news articles 
	 * @throws Exception 
	 */
	List<Article> loadRSSNews(String uri) throws Exception; 	
}
