package es.uem.geonames;

import com.google.common.base.Predicate;

import es.uem.geonames.model.CountryInfo;

public class ShouldIsoAlpha2Predicate implements Predicate<CountryInfo> {
	private String countryCode;

	public ShouldIsoAlpha2Predicate(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean apply(CountryInfo input) {
		if (input.getCountryCode().equalsIgnoreCase(countryCode)) {
			return true; 
		}
		return false;
	} 
}
