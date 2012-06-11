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
package es.uem.gazetteer;

import java.io.Serializable;

import org.geonames.Style;

import com.google.common.base.Objects;

/**
 * a GeoNames toponym 
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 * 
 */
@SuppressWarnings("serial")
public class Toponym implements Serializable {

	private int geoNameId;
	private String name;
	private String alternateNames;
	private String continentCode;
	private String countryCode;
	private String countryName;
	private Long population;
	private Integer elevation;
	private String featureClass; 
	private String featureClassName;
	private String featureCode;
	private String featureCodeName; 
	private double latitude;
	private double longitude;	
	private double score; 
	private double disambiguationScore; 		

	/**
	 * Constructor 
	 */
	public Toponym() {
		
	}
	
	/**
	 * Constructor for Continent  
	 * 
	 * 	<toponymName>Asia</toponymName>
	 * 	<name>Asia</name>
	 *  <lat>29.84064</lat>
	 *  <lng>89.29688</lng>
	 *  <geonameId>6255147</geonameId>
	 *  <countryCode/>
	 *  <countryName/>
	 *  <fcl>L</fcl>
	 *  <fcode>CONT</fcode>
	 * @param continentInfo
	 */
	/*public Toponym(ContinentInfo continentInfo) {
		this.geoNameId = continentInfo.getGeonameId(); 
		this.name = continentInfo.getName(); 
		this.latitude = continentInfo.getLat(); 
		this.longitude = continentInfo.getLng(); 
		this.featureClass = continentInfo.getFcl(); 
		this.featureCode = continentInfo.getFcode();
	}*/
			
	
	/**
	 * @return the continentCode
	 */
	public String getContinentCode() {
		return continentCode;
	}

	/**
	 * @param continentCode
	 *            the continentCode to set
	 */
	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	/**
	 * @return Returns the ISO 3166-1-alpha-2 countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            The ISO 3166-1-alpha-2 countryCode to set.
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return Returns the elevation in meter.
	 */
	public Integer getElevation() {
		return elevation;
	}

	/**
	 * @param elevation
	 *            The elevation im meter to set.
	 */
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	/**
	 * @see <a href="http://www.geonames.org/export/codes.html">GeoNames Feature
	 *      Codes</a>
	 * @return Returns the featureCode.
	 */
	public String getFeatureCode() {
		return featureCode;
	}

	/**
	 * @param featureCode
	 *            The featureCode to set.
	 */
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	/**
	 * latitude in decimal degrees (wgs84)
	 * 
	 * @return Returns the latitude.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            The latitude to set.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * longitude in decimal degrees (wgs84)
	 * 
	 * @return Returns the longitude.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            The longitude to set.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the population.
	 */
	public Long getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            The population to set.
	 */
	public void setPopulation(Long population) {
		this.population = population;
	}

	/**
	 * @return Returns the geoNameId.
	 */
	public int getGeoNameId() {
		return geoNameId;
	}

	/**
	 * @param geoNameId
	 *            The geoNameId to set.
	 */
	public void setGeoNameId(int geonameId) {
		this.geoNameId = geonameId;
	}

	/**
	 * @return Returns the featureClass.
	 */
	public String getFeatureClass() {
		return featureClass;
	}

	/**
	 * @param featureClass
	 *            The featureClass to set.
	 */
	public void setFeatureClass(String featureClass) {
		this.featureClass = featureClass;
	}
	
	/**
	 * @return Returns the featureClassName.
	 */
	public String getFeatureClassName() {
		return featureClassName;
	}

	/**
	 * @param featureClassName
	 *            The featureClassName to set.
	 */
	public void setFeatureClassName(String featureClassName) {
		this.featureClassName = featureClassName;
	}

	/**
	 * @return Returns the featureCodeName.
	 */
	public String getFeatureCodeName() {
		return featureCodeName;
	}

	/**
	 * @param featureCodeName
	 *            The featureCodeName to set.
	 */
	public void setFeatureCodeName(String featureCodeName) {
		this.featureCodeName = featureCodeName;
	}

	/**
	 * @return Returns the countryName.
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            The countryName to set.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * alternate names of this place as comma separated list
	 * 
	 * @return the alternateNames as comma separated list
	 */
	public String getAlternateNames() {
		return alternateNames;
	}

	/**
	 * @param alternateNames
	 *            the alternateNames to set
	 */
	public void setAlternateNames(String alternateNames) {
		this.alternateNames = alternateNames;
	}
		
	/**
	 * 
	 * @return the Score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * the Score 
	 * @param score the Score
	 */
	public void setScore(double score) {
		this.score = score;
	}
		
	/**
	 * 
	 * @return the Disambiguation Score
	 */
	public double getDisambiguationScore() {
		return disambiguationScore;
	}

	/**
	 * the Disambiguation Score 
	 * @param disambiguationScore the Disambiguation Score
	 */
	public void setDisambiguationScore(double disambiguationScore) {
		this.disambiguationScore = disambiguationScore;
	}
	
	
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
				.add("disambiguationScore", this.getDisambiguationScore())
				.add("score", this.getScore())
				.toString(); 
	}

}