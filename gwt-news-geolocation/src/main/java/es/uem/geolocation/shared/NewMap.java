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

package es.uem.geolocation.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**  
 * 
 * News map 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es) 
 */
@SuppressWarnings("serial")
public class NewMap implements Serializable {	
	private String placename = "";
	private Double latitude = null;  
	private Double longitude = null;
	private List<Article> articles = new ArrayList<Article>(); 
	
	public NewMap() { 		
	}
	
	public NewMap(String placename, Double latitude, Double longitude,
			List<Article> articles) {
		this.placename = placename;
		this.latitude = latitude;
		this.longitude = longitude;
		this.articles = articles;
	}

	public String getPlacename() {
		return placename;
	}
	
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public List<Article> getArticles() {
		return this.articles; 
	}

	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder(); 
		sb.append("NewMap [placename="); 
		sb.append(placename); 
		sb.append(", latitude="); 
		sb.append(latitude); 
		sb.append(", longitude="); 
		sb.append(longitude); 
		sb.append(", articles="); 
		sb.append(articles); 
		sb.append("]"); 
		
		return sb.toString();		
	}
	

	
	
			
}
