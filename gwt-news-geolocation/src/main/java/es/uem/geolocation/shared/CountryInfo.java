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
import java.util.List;

import com.google.common.base.Objects;

/**
 * a GeoNames countryinfo
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
@SuppressWarnings("serial")
public class CountryInfo extends Toponym implements Serializable {
	
	//private int geoNameId;
	private String isoAlpha2; 
	private String isoAlpha3;
	private int isoNumeric; 
	private String fipsCode;
	//private String name;
	private String capital;  
	private double areaInSqKm; 
	//private Long population; 
	private String continent; 
	private List<String> languages; 
	private String currency; 
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("geoNameId", this.getGeoNameId())
				.add("name", this.getName())
				.add("alternateNames", this.getAlternateNames())
				.add("featureClass", this.getFeatureClass())
				.add("featureClassName", this.getFeatureClassName())
				.add("featureCode", this.getFeatureCode())
				.add("featureCodeName", this.getFeatureCodeName())
				.add("continentCode", this.getContinentCode())
				.add("countryCode", this.getCountryCode())
				.add("countryName", this.getCountryName())
				.add("latitude", this.getLatitude())
				.add("longitude", this.getLongitude())
				.add("population", this.getPopulation())
				.add("elevation", this.getElevation())				
				.toString(); 
	}

}