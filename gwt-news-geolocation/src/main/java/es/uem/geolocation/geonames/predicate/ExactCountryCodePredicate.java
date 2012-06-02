package es.uem.geolocation.geonames.predicate;

import com.google.common.base.Predicate;

import es.uem.geolocation.shared.ToponymCountry;

/**
 * 
 * Exact Country Code.
 *     
 *  	Ej. GB=Reino Unido, 
 *  		ES=España, ...
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class ExactCountryCodePredicate implements Predicate<ToponymCountry> {
	private String countryCode;

	/**
	 * Constructor 
	 * 
	 * @param countryCode the Country Code 
	 */
	public ExactCountryCodePredicate(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean apply(ToponymCountry input) {
		if (input.getCountryCode().equalsIgnoreCase(countryCode)) {
			return true; 
		}
		return false;
	}	
}
