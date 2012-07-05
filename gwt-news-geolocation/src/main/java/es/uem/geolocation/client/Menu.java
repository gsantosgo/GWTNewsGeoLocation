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

import com.google.common.base.Objects;

/**
 *  
 * Class Menu
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class Menu {
	private String uri; 
	private String countryCode;
		
	/**
	 * Constructor
	 * 
	 * @param uri the Uri source RSS 
	 * @param countryCode the countryCode "ES" 
	 */
	public Menu(String uri, String countryCode) {
		this.uri = uri;
		this.countryCode = countryCode;
	}

	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountry(String countryCode) {
		this.countryCode = countryCode;
	} 
	
	@Override
	public String toString() {		
		return Objects.toStringHelper(this.getClass())				
				.add("uri", this.getUri())
				.add("countryCode", this.getCountryCode())
				.toString();
	}			
}
