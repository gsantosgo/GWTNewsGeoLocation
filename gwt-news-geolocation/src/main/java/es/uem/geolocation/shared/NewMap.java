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

import com.google.common.base.Objects;

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
	
	public NewMap(String placename, Double latitude, Double longitude, List<Article> articles) {
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
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public List<Article> getArticles() {
		return this.articles; 
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("placeName", this.getPlacename())
				.add("latitude", Objects.firstNonNull(this.getLatitude(), ""))
				.add("longitude", Objects.firstNonNull(this.getLongitude(), ""))
				.add("articles", this.getArticles().toString())
				.toString(); 
	}
				
}
