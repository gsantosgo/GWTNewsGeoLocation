package es.uem.geolocation.geonames.predicate;

import com.google.common.base.Predicate;

import es.uem.geolocation.shared.ToponymCountry;

/**
 * 
 * Exact ISOAlpha3.
 * 
 * ISO 3166-1 alpha-3 codes are three-letter country codes defined in ISO 3166-1, 
 * part of the ISO 3166 standard published by the International Organization for 
 * Standardization (ISO), to represent countries, dependent territories, and 
 * special areas of geographical interest.
 * 
 *  	Ej. USA=Estados Unidos, ESP=España,...
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class ExactIsoAlpha3Predicate implements Predicate<ToponymCountry> {
	private String isoAlpha3;

	public ExactIsoAlpha3Predicate(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public boolean apply(ToponymCountry input) {
		if (input.getIsoAlpha3().equalsIgnoreCase(isoAlpha3)) {
			return true; 
		}
		return false;
	}	 
}
