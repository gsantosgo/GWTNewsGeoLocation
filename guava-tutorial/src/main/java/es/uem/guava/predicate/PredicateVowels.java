package es.uem.guava.predicate;

import com.google.common.base.Predicate;

import es.uem.guava.Person;

public class PredicateVowels implements Predicate<Person>{

	String[] vowels = { "a", "e", "i", "o", "u", "y" };
	
	public boolean apply(Person person) {
		String firstName = person.getName().toLowerCase();
		// convert to lowercase just in case

		// for each vowel check if
		// first name begins with that
		// vowel
		for (String vowel : vowels) {
			if (firstName.startsWith(vowel))
				return true;
		}

		return false;
	}
	
}
