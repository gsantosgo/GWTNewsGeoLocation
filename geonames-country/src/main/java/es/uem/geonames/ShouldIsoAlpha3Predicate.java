package es.uem.geonames;

import com.google.common.base.Predicate;

import es.uem.geonames.model.CountryInfo;

public class ShouldIsoAlpha3Predicate implements Predicate<CountryInfo> {
	private String isoAlpha3;

	public ShouldIsoAlpha3Predicate(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public boolean apply(CountryInfo input) {
		if (input.getIsoAlpha3().equalsIgnoreCase(isoAlpha3)) {
			return true; 
		}
		return false;
	}	
 
}
