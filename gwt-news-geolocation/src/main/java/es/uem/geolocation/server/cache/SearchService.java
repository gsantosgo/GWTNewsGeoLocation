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

/**
 * Search Service
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public interface SearchService<T> {
	 T search(String query);
	 //T searchCountry(String query) throws Exception; 
	 //T hierarchy(int geonameId, String language, Style style) throw Exception;
}
