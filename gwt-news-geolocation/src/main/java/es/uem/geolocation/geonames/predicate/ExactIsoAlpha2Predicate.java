package es.uem.geolocation.geonames.predicate;

import com.google.common.base.Predicate;

import es.uem.geolocation.shared.ToponymCountry;

/**
 * 
 * Exact ISOAlpha2.
 * 
 * ISO 3166-1 alpha-2 codes are two-letter country codes defined in ISO 3166-1, 
 * part of the ISO 3166 standard published by the International Organization 
 * for Standardization (ISO), to represent countries, dependent territories, a
 * and special areas of geographical interest. They are the most widely 
 * used of the country codes published by ISO
 * 
 *  	Ej. GB=Reino Unido, US=Estados Unidos, ES=España,...
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 *
 */
public class ExactIsoAlpha2Predicate implements Predicate<ToponymCountry> {
	private String isoAlpha2;

	public ExactIsoAlpha2Predicate(String isoAlpha2) {
		this.isoAlpha2 = isoAlpha2;
	}

	public boolean apply(ToponymCountry input) {
		if (input.getCountryCode().equalsIgnoreCase(isoAlpha2)) {
			return true; 
		}
		return false;
	} 
}
