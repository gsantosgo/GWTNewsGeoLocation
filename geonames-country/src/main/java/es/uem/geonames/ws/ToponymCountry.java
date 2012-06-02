/*
 * Copyright 2008 Marc Wick, geonames.org
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
 *
 */
package es.uem.geonames.ws;

import org.geonames.Toponym;

import com.google.common.base.Objects;

/**
 * a GeoNames toponym
 * 
 * @author marc@geonames
 * 
 */
public class ToponymCountry extends Toponym {	
	private String isoAlpha2; //countryCode 
	private String isoNumeric;
	private String isoAlpha3;
	private String fipsCode;
	private String continentName;	
	private String capital; 
	private double areaInSqKm;  //double	
	private String currencyCode;	
	private String languages; // es-ES,ca,gl,eu,oc
	
	// <west>25.66388</west><north>81.85193</north><east>-168.98975</east><south>-10.93</south>	
	private double west;
	private double north; 
	private double east; 
	private double south;	
	
	
	
	public String getIsoAlpha2() {
		return isoAlpha2;
	}

	public void setIsoAlpha2(String isoAlpha2) {
		this.isoAlpha2 = isoAlpha2;
	}

	public String getIsoNumeric() {
		return isoNumeric;
	}

	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}

	public String getIsoAlpha3() {
		return isoAlpha3;
	}

	public void setIsoAlpha3(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public String getFipsCode() {
		return fipsCode;
	}

	public void setFipsCode(String fipsCode) {
		this.fipsCode = fipsCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getAreaInSqKm() {
		return areaInSqKm;
	}

	public void setAreaInSqKm(double areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	/** 
	 * @return the West 
	 */
	public double getWest() {
		return west;
	}
	
	/**
	 * 
	 * @param west
	 * 		the West
	 */
	public void setWest(double west) {
		this.west = west;
	}
	
	/** 
	 * @return the North 
	 */
	public double getNorth() {
		return north;
	}
	
	/**
	 * 
	 * @param north the North
	 */
	public void setNorth(double north) {
		this.north = north;
	}
	
	/**
	 * 
	 * @return the East
	 */
	public double getEast() {
		return east;
	}
	
	/**
	 * 
	 * @param east the East
	 */
	public void setEast(double east) {
		this.east = east;
	}
	
	/**
	 * 
	 * @return the South 
	 */
	public double getSouth() {
		return south;
	}
	
	/**
	 * 
	 * @param south the South 
	 */
	public void setSouth(double south) {
		this.south = south;
	}
	
	@Override
	public String toString() {		
		return Objects.toStringHelper(this.getClass())
				.add("toponym", super.toString())				
				.add("countryName", this.getCountryCode())
				.add("countryCode", this.getCountryName())
				.add("isoAlpha2", this.getIsoAlpha2())
				.add("isoNumeric", this.getIsoNumeric())
				.add("isoAlpha3", this.getIsoAlpha3())
				.add("fipsCode", this.getFipsCode())
				.add("continentCode", this.getContinentCode())
				.add("continentName", this.getContinentName())
				.add("capital", this.getCapital())
				.add("areaInSqKm", this.getAreaInSqKm())
				.add("currencyCode", this.getCountryCode())
				.add("languages", this.getLanguages())
				.add("west", this.getWest()) 
				.add("north", this.getNorth())
				.add("east", this.getEast())
				.add("south", this.getSouth())
				.toString();
	}
}
