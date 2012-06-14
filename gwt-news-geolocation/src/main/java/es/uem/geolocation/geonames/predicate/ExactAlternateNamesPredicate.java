package es.uem.geolocation.geonames.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;

import es.uem.geolocation.shared.ToponymCountry;

/**
 * 
 * Exact Alternate Names 
 *     
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class ExactAlternateNamesPredicate implements Predicate<ToponymCountry> {
	private String name;

	/**
	 * Constructor 
	 * 
	 * @param name the Alternate name candidate 
	 */
	public ExactAlternateNamesPredicate(String name) {
		this.name = name;
	}

	/**
	 * Apply 
	 */
	public boolean apply(ToponymCountry input) {
		Iterable<String> alternateNames = Splitter.on(",").omitEmptyStrings().trimResults().split(input.getAlternateNames());

		for (String alternateName : alternateNames) {
			if (alternateName.equalsIgnoreCase(name)) return true;
		}
		return false;
	}	
}
