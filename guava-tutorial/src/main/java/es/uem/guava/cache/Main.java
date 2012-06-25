package es.uem.guava.cache;

import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		PersonSearchServiceImpl personSearchServiceImpl = new PersonSearchServiceImpl(); 

		List<String> hola = personSearchServiceImpl.search("hola"); 
		
		List<String> hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());		
		
		hola = personSearchServiceImpl.search("hola"); 
		
		hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());

		hola = personSearchServiceImpl.search("hola"); 
		
		hola2 = personSearchServiceImpl.search("hola2");
		
		System.out.println(hola.size());
		System.out.println(hola2.size());		
	}

}

