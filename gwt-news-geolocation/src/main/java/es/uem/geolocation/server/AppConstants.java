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

import com.google.gwt.i18n.client.Constants;

/**
 * Server's Constants 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public interface AppConstants extends Constants {		
	// Proxy Configuration 
	@DefaultBooleanValue(true)	
	public boolean isProxy();
	@DefaultStringValue("10.14.79.204")
	public String proxyHostName();
	@DefaultIntValue(8080)
	public int proxyPort(); 
	
	// RSS Service
	@DefaultIntValue(5 * 1000)
	public int connectTimeOut();
	
	// Web Services Geonames 
	@DefaultIntValue(5 * 1000)
	public int geonamesWebServiceConnectTimeOut();
	@DefaultStringValue("gsantosgo")
	public String geonamesWebServiceUsername();  
}
