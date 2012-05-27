package es.uem.geonames.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * 
 * @author gsantos
 *
 */
public class CountryInfo implements Serializable{
	
	private String countryCode; 
	private String countryName; 
	private String isoNumeric;
	private String isoAlpha3;
	private String fipsCode; 
	private String continent; 
	private String continentName; 
	private String capital; 
	private String areaInSqKm;  //double
	private String population; //long 
	private String currencyCode;
	private String languages; // es-ES,ca,gl,eu,oc
	private String geonameId; //int
	private String west; //double 
	private String north; //double
	private String east; //double
	private String south;//double
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
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
		try  { 
			return Double.valueOf(this.areaInSqKm);
		} catch (NumberFormatException nfe){
			return 0.0;
		}
	}
	public void setAreaInSqKm(String areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}
	public long getPopulation() {
		try  { 
			return Long.valueOf(this.population);
		} catch (NumberFormatException nfe){
			return 0L;
		}
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public int getGeonameId() {
		try  { 
			return Integer.valueOf(this.geonameId);
		} catch (NumberFormatException nfe){
			return 0;
		}
	}
	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}
	public double getWest() {
		try  { 
			return Double.valueOf(this.west);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}
	}
	public void setWest(String west) {
		this.west = west;
	}
	public double getNorth() {
		try  { 
			return Double.valueOf(this.north);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}

	}
	public void setNorth(String north) {
		this.north = north;
	}
	public double getEast() {
		try  { 
			return Double.valueOf(this.east);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}
	}
	public void setEast(String east) {
		this.east = east;
	}
	public double getSouth() {
		try  { 
			return Double.valueOf(this.south);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}
	}
	public void setSouth(String south) {
		this.south = south;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("countryCode", this.getCountryCode()) 
				.add("countryName", this.getCountryName())
				.add("isoNumeric", this.getIsoNumeric())
				.add("isoAlpha3", this.getIsoAlpha3())
				.add("fipsCode", this.getFipsCode()) 
				.add("continent", this.getContinent())
				.add("continentName", this.getContinentName())
				.add("capital", this.getCapital())
				.add("areaInSqKm", this.getAreaInSqKm())
				.add("population", this.getPopulation()) 
				.add("currencyCode", this.getCurrencyCode())
				.add("languages", this.getLanguages())
				.add("geonameId", this.getGeonameId())
				.add("west", this.getWest())
				.add("north", this.getNorth())
				.add("east", this.getEast())
				.add("south", this.getSouth())
				.toString();
	}
}

