package es.uem.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import es.uem.guava.predicate.PredicateVowels;

public class Main {

	/**
	 * Main program
	 * 
	 * http://scaramoche.blogspot.com.es/2010/08/googles-guava-library-tutorial-part-4.html 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Person frodo = new Person("Frodo", "Baggins");
		Person sezin = new Person("Sezin", "Karli");
		Person luke = new Person("Luke", "Skywalker");
		Person anakin = new Person("Anakin", "Skywalker");
		Person eric = new Person("Eric", "Draven");

		HashSet<Person> setOfPerson = Sets.newHashSet( eric, frodo, sezin, luke, anakin );
		System.out.println("set of person: "+setOfPerson);
		// [Sezin Karli, Luke Skywalker, Anakin Skywalker, Frodo Baggins]
		
		
		
		Set<Person> view = Sets.filter(setOfPerson, new PredicateVowels());
		System.out.println("view: "+view); 
		// filter: [Eric Draven, Anakin Skywalker]
		// we remove eric from the view
		view.remove(eric);
		System.out.println("new view: "+view);
		// new view: [Anakin Skywalker]
		System.out.println("set of person: "+setOfPerson); 
		// [set of person: [Sezin Karli, Luke Skywalker, Anakin Skywalker, Frodo Baggins]
		
		/*
		 * As you can see the removal of an item from the view causes the same removal 
		 * from the origin set. This removal action is bidirectional. e.g. removal 
		 * from the origin set will remove the corresponding element from the view.
		 */
		
		

		Person bilbo = new Person("Bilbo", "Baggins");
		Person alex = new Person("Alex", "Delarge");
		setOfPerson.add(bilbo);
		setOfPerson.add(alex);
		System.out.println("new view: "+view);
		// new view: [Anakin Skywalker, Alex Delarge]
		
		/*
		 * The view is updated as well and the elements that are accepted 
		 * by the predicate are added to the view. In the case above only alex is accepted. you can try add a new element to the view which does not met the predicate's requirement.
		 */
		
		
		Map<String,Integer> characterAppearancesMap = Maps.newHashMap();
		characterAppearancesMap.put("Mario", 15);
		characterAppearancesMap.put("Snake", 8);
		characterAppearancesMap.put("Kratos", 4);
		

		Predicate <String>  allowNamesWithO = new Predicate <String> (){
		 //@Override
		 public boolean apply(String name) {
		  String lowerCaseName = name.toLowerCase();
		
		  return lowerCaseName.contains("o");
		 }
		};
		
		Predicate <Integer> allowLotsOfAppearances = new Predicate <Integer> (){
		 //@Override
		 public boolean apply(Integer appearance) {
		  int numberOfAppearance = appearance.intValue();
		
		  return (numberOfAppearance > 10);
		 }
		};

		
		Map <String,Integer>  filterKeys = new HashMap<String, Integer> ( Maps.filterKeys(characterAppearancesMap, allowNamesWithO) );
		// I copy the live view
		System.out.println("Game Characters with 'o' in their name: "+filterKeys);
		// {Mario=15, Kratos=4}

		Map <String,Integer>  filterValues = Maps.filterValues(filterKeys, allowLotsOfAppearances);
		System.out.println("Game Characters with 'o' in their name and with more than 10 appearances: "+filterValues);
		//{Mario=15}
		

		/*
		 * You can obtain the desired map by writing a single Predicate that will contain 
		 * both predicates and use this Predicate on entries of a Map. It's not possible 
		 * for Predicates.and() because we have to apply the Predicate on both keys and 
		 * values but new Predicate built using and() can only be applied on keys or values
		 */
		

		// AND 
		Predicate <Map.Entry<String,Integer>> characterPredicate =
				new Predicate<Map.Entry<String,Integer>>(){

			 public boolean apply(Entry<String,Integer> entry) {
			  String key = entry.getKey();
			  int value = entry.getValue().intValue();
			
			  return (key.contains("o") && value  > 10);
			 }
			
			};

		Map <String, Integer> filterEntries =
		 Maps.filterEntries(characterAppearancesMap, characterPredicate);
		System.out.println("Are the game character results same? "+filterEntries.equals(filterValues));
		// As you can see the result is the same

		
		
		


		Function<Person,Boolean> vowelVerifier = Functions.forPredicate(new PredicateVowels());
		ArrayList<Person>  people = Lists.newArrayList(anakin, bilbo, alex);
		List<Boolean> transform2 = Lists.transform(people, vowelVerifier);
		// Vowel verifier will return TRUE (FALSE) for each
		// 	person with TRUE (FALSE) Predicate result 
		System.out.println("Result: "+transform2); 
		// [true, false, true]
		// anakin and alex are true because the Predicate
		// was checking to see if the first name of the Person
		// begins with a vowel

		


		Predicate<Character> allowVowel = new Predicate <Character> (){
		 char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };
		 
		 public boolean apply(Character character) {
		  char lowerCase = Character.toLowerCase(character.charValue());
		
		  for(char chr : vowels){
		   if(chr == lowerCase)
		    return true;
		  }
		
		  return false;
		 }
		};

	
		CharMatcher vowelMatcher = CharMatcher.forPredicate(allowVowel);
		int vowelCount = vowelMatcher.countIn("starkiller");
		System.out.println("Vowel Count in 'starkiller': "+vowelCount);

		
		/*
		 * Assume that we don't want people with long last names. 
		 * Our character limit can be 8 for instance. Lets write a 
		 * Predicate for the purpose.
		 */

		Predicate<Person> allowShortLastNames = new Predicate<Person>() {
			
			 public boolean apply(Person person) {
			  String lastName = person.getLastName();			
			  return (lastName.length() < 8);
			 }
		};

			System.out.println(setOfPerson);
			// [Alex Delarge, Frodo Baggins, Anakin Skywalker,
			//  Luke Skywalker, Bilbo Baggins, Sezin Karli]
			
			Set<Person> onlyShortLastNames = 
			Sets.filter(setOfPerson, allowShortLastNames);
			System.out.println("People with short last names: "+onlyShortLastNames);
			//[Sezin Karli, Alex Delarge, Bilbo Baggins, Frodo Baggins]


			Predicate <Person>  combinedPredicates = Predicates.and(allowShortLastNames, new PredicateVowels());
			Set <Person>  filter = Sets.filter(setOfPerson, combinedPredicates);
			System.out.println("Combined Predicates: "+filter); 
			// Alex Delarge
			
			

		Predicate <Person> allowShortFirstNames = new Predicate<Person>(){
		
			 public boolean apply(Person person) {
				 String firstName = person.getName();
			
				 return (firstName.length()  <  8);
			 }
		};

		Predicate <Person>  predicatesCombinedWithOr = 
		Predicates.or(allowShortLastNames, allowShortFirstNames);
		filter = Sets.filter(setOfPerson, predicatesCombinedWithOr);
		System.out.println(setOfPerson);
		System.out.println("Combined with or:"+filter);

		// As you can see nothing is filtered because
		// setOfPerson elements have either short
		// first names or short last names
		// Lets add a person with a long first name
		// and last name

		setOfPerson.add(new Person("Abdullah", "Jabbarian"));
		filter = Sets.filter(setOfPerson, predicatesCombinedWithOr);
		System.out.println("Combined with or 2: "+filter);
		// [Alex Delarge, Frodo Baggins, Anakin Skywalker, 
		// Luke Skywalker, Bilbo Baggins, Sezin Karli]
		
		// As you can see Abdullah who has a long first and last name
		// is not in the new set.		

		

		Predicate<Person> negatedPredicates = Predicates.not(combinedPredicates);

		//Alex delarge was the only person with the predicate in hand.
		//When we negate the predicate
		//we will get a predicate that will return
		//every element but alex delarge

		filter = Sets.filter(setOfPerson, negatedPredicates);
		System.out.println("Negated and combined Predicates: "+filter); 
		// [Frodo Baggins, Anakin Skywalker, Abdullah Jabbarian, 
		// Luke Skywalker, Bilbo Baggins, Sezin Karli]
	}
}
