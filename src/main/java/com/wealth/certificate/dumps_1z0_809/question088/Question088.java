package com.wealth.certificate.dumps_1z0_809.question088;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import static java.util.stream.Collectors.toList;
public class Question088 {
	static List<Employee> employeeList =
		     Arrays.asList(new Employee("Tom Jones", 45), 
		       new Employee("Harry Major", 25),
		       new Employee("Ethan Hardy", 65),
		       new Employee("Nancy Smith", 15),
		       new Employee("Deborah Sprightly", 29));
	
	public static void main(String[] args) {
		UnaryOperator<Integer> uo1 = s -> s*2;//line n1 
		List<Double> loanValues = Arrays.asList(1000.0, 2000.0); 
        System.out.println(uo1.apply(1));
		loanValues.stream().filter(lv -> lv >= 1500).map(lv -> uo1.apply(lv.intValue())).forEach(s -> System.out.print(s + " "));
		//loanValues.stream().parallel().filter(lv -> lv >= 1500).map(lv -> new Double(1.0)).forEach(s -> System.out.print(s + " "));
		/* map receive function and return to stream , which UnaryOperator is Extend function but different of unaryOpertor is it's seem in / out the same parameter type
		All of interface functional allow you to use lampda expression
		map ::  <R> Stream<R> map(Function<? super T,? extends R> mapper)
		flatMap :: <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
		 */
		
		List<String> nameCharList = employeeList.stream()
		           .map(emp-> emp.getName().split(""))
		           .flatMap(array->Arrays.stream(array))
		           .map(str -> str.toUpperCase()) 
		           .filter(str -> !(str.equals(" ")))
		           .collect(toList());
		   nameCharList.forEach(str -> System.out.print(str));
		   

	}
		
}

class Employee {
	public String name;
	public Integer age;
	public Employee(String name , Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}