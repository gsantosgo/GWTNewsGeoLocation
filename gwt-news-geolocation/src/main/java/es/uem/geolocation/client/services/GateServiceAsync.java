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

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import es.uem.geolocation.shared.Article;

/**
 * Asynchronous interface <code>GateService</code>.
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public interface GateServiceAsync {	
	void getNamedEntities(String texto, AsyncCallback<List<String>> asyncCallback) throws Exception;
	void getNamedEntities(List<Article> articles, AsyncCallback<List<Article>> asyncCallback) throws Exception;	
}
