package es.uem.geonames.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * 
 * @author gsantos
 *
 */
public class ContinentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7448187074816948650L;
	private String toponymName; 
	private String name; 
	private String lat; // double
	private String lng; // double
	private String geonameId; //int 
	private String countryCode; 
	private String countryName; 
	private String fcl;
	private String fcode;
	
	public String getToponymName() {
		return toponymName;
	}
	public void setToponymName(String toponymName) {
		this.toponymName = toponymName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		try  { 
			return Double.valueOf(this.lat);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}
	}
	public void setLat(String latitude) {
		this.lat = latitude;
	}
	public double getLng() {
		try  { 
			return Double.valueOf(this.lng);
		} catch (NumberFormatException nfe){
			return Double.NaN;
		}
	}
	public void setLongitude(String lng) {
		this.lng = lng;
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
	public String getFcl() {
		return fcl;
	}
	public void setFcl(String fcl) {
		this.fcl = fcl;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}


	@Override
	public String toString() {		
		return Objects.toStringHelper(this.getClass())
				.add("toponymName", this.getToponymName()) 
				.add("name", this.getName())
				.add("latitude", this.getLat())
				.add("longitude", this.getLng())
				.add("geonameId", this.getGeonameId())
				.add("countryCode", this.getCountryCode())
				.add("countryName", this.getCountryName())
				.add("fcl", this.getFcl())
				.add("fcode", this.getFcode())
				.toString();
	}
	
}