package es.uem.geonames;

import com.google.common.base.Predicate;

public class ShouldNamePredicate implements Predicate<String> {
	private String name;

	public ShouldNamePredicate(String name) {
	this.name = name;
	}

	public boolean apply(String name) {
		if (this.name.equalsIgnoreCase(name)) {
			return true; 
		}
		return false;
	} 
}
