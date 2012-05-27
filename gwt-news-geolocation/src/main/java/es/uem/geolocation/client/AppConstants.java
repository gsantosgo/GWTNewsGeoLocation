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
package es.uem.geolocation.client;

import com.google.gwt.i18n.client.Constants;

/**
 * 
 * Client's constants 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public interface AppConstants extends Constants {
	
	// Application ===== 
	public String applicationName(); 
	public String version();
	public String author();
	public String detail();
	
	@DefaultStringValue("dd/MM/yyyy HH:mm:ss")
	public String formatDateTime(); 	
		
	// Custom marker image ===== 
	@DefaultStringValue("images/redpushpin.png")
	public String markerImage(); 
}
