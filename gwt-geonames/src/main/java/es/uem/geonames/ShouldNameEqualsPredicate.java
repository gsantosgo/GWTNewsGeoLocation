package es.uem.geonames;

import com.google.common.base.Predicate;

public class ShouldNameEqualsPredicate implements Predicate<String>{
	private String name; 
	
	/**
	 * Constructor 
	 * 
	 * @param name
	 */
	public ShouldNameEqualsPredicate(String name) {
		this.name = name; 
	}
	
	public boolean apply(String input) {		
		if (name.toLowerCase().equals(input.toLowerCase())) {
			return true;
		}
		return false;
	}
	

}

 
