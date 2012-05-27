package es.uem.geolocation.geonames.predicate;

import com.google.common.base.Predicate;

import es.uem.geolocation.geonames.model.CountryInfo;

/**
 * 
 * Exact FipsCode.
 *  
 * FipsCode:   
 *  The two-letter country codes were used by the US government for geographical 
 *  data processing in many publications, such as the CIA World Factbook. 
 *  	Ej. UK=Reino Unido, ESP=España,...
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class ExactFipsCodePredicate implements Predicate<CountryInfo> {
	private String fipsCode;

	/**
	 * Constructor 
	 * 
	 * @param fipsCode
	 */
	public ExactFipsCodePredicate(String fipsCode) {
		this.fipsCode = fipsCode;
	}

	public boolean apply(CountryInfo input) {
		if (input.getFipsCode().equalsIgnoreCase(fipsCode)) {
			return true; 
		}
		return false;
	}	
}
