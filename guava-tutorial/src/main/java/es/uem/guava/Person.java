package es.uem.guava;


public class Person implements Comparable<Person> {	
	private String name;
	private String lastName;

	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int compareTo(Person arg0) {
		return this.getName().compareTo(arg0.getName());
	}

	@Override
	public String toString() {
		return this.name + " " + this.lastName;
	}


}
