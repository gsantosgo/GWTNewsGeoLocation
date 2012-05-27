package es.uem.guava;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class MainEmployee {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Employee sezinKarli = new Employee(4, "Sezin Karli", 4);
		Employee darthVader = new Employee(3, "Darth Vader", 5);
		Employee hanSolo = new Employee(2, "Han Solo", 10);
		List<Employee> employeeList = Lists.newArrayList(sezinKarli, hanSolo,
				darthVader);
		System.out.println("employee list: " + employeeList);
		// output:
		// employee list: [id=4-name=Sezin Karli-years of service=4,
		// id=2-name=Han Solo-years of service=10,
		// id=3-name=Darth Vader-years of service=5]

		

		Comparator<Employee> yearsComparator = new Comparator<Employee>(){
			 public int compare(Employee employee1, Employee employee2) {
				 return (employee1.getYearsOfService() - employee2.getYearsOfService());  
			 }
		};

		Comparator<Employee> idComparator = new Comparator<Employee>(){
			public int compare(Employee employee1, Employee employee2) {
				return (employee1.getId() - employee2.getId());  
			}
		};

		// Create an Ordering from a Comparator
		Ordering<Employee> orderUsingYearsComparator = Ordering.from(yearsComparator);
		// Sort the employee list using years comparator
		List<Employee> sortedCopy = orderUsingYearsComparator.sortedCopy(employeeList);
		System.out.println("sorted copy based on years of service comparator: "+sortedCopy);
		/*
		output:
		sorted copy based on years of service comparator: 
		[id=4-name=Sezin Karli-years of service=4,
		 id=3-name=Darth Vader-years of service=5,
		 id=2-name=Han Solo-years of service=10]
		
		*/
		
	}
}
