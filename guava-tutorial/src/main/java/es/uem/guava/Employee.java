package es.uem.guava;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private int yearsOfService;

	public Employee(int id, String name, int yearsOfService) {
		this.id = id;
		this.name = name;
		this.yearsOfService = yearsOfService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public int compareTo(Employee employee) {
		return this.getName().compareTo(employee.getName());
	}

	@Override
	public String toString() {
		String toString = "id=" + id + ";name=" + name + ";years of service="
				+ yearsOfService;

		return toString;
	}

}
