package es.uem.geonames;

import com.google.common.base.Predicate;

import es.uem.geonames.model.CountryInfo;

public class ShouldFipsCodePredicate implements Predicate<CountryInfo> {
	private String fipsCode;

	public ShouldFipsCodePredicate(String fipsCode) {
	this.fipsCode = fipsCode;
	}

	public boolean apply(CountryInfo input) {
		if (input.getFipsCode().equalsIgnoreCase(fipsCode)) {
			return true; 
		}
		return false;
	}	
}
