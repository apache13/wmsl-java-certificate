package com.wealth.certificate.dumps_1z0_809.question043.ext;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MySortObject implements Comparable<MySortObject> {

	String fName;
	String lName;

	public MySortObject(String fn, String ln) {
		fName = fn;
		lName = ln;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}
		
	public static void print(List<MySortObject> printEmp) {		
		printEmp.stream().forEach(p -> System.out.println(p.getfName()+" "+p.getlName()) );
		System.out.println("--------------------");
	}
			
	public static void main(String[] args) {
		
		List<MySortObject> emp = Arrays.asList (new MySortObject ("111", "333"), new MySortObject ("222", "222"), new MySortObject ("222", "111"));		
		
		print(emp);		
		
		// Sorted by Comparator interface with Anonymous inner class 		
		emp.stream().sorted(new Comparator<MySortObject>(){
			@Override
			public int compare(MySortObject o1, MySortObject o2) {
				return o1.getfName().compareTo(o2.getfName());
			}} 
		).forEach(p -> System.out.println(p.getfName()+" "+p.getlName()) );
				
		// Sorted by Comparator interface  with Lambda (@FunctionalInterface)
		emp.stream().sorted( (a,b) -> b.getfName().compareTo(a.getfName())).forEach(p -> System.out.println(p.getfName()) );
		
		emp.stream().sorted( (a,b) -> {return b.getfName().compareTo(a.getfName());} ).forEach(p -> System.out.println(p.getfName()) );
					
		emp.stream().sorted( (a,b)-> {
			int result = b.getfName().compareTo(a.getfName());
			if( result == 0 ) {
				return a.getlName().compareTo(b.getlName());
			}else {
				return result;
			}			
		} ).forEach(p->System.out.println(p.getfName()+" "+p.getlName()));
		
		
		
		
		
		
		// Implement comparable
		emp.stream().sorted().forEach(p -> System.out.println(p.getfName()) );
		emp.stream().sorted(Comparator.naturalOrder()).forEach(p -> System.out.println(p.getfName()) );
		emp.stream().sorted(Comparator.reverseOrder()).forEach(p -> System.out.println(p.getfName()) );
		
				
		// Sort by Function reference
		// Sorted by Comparator interface  with Function reference
		Function<MySortObject, String> keyExtractor = new Function<MySortObject, String>() {
			@Override
			public String apply(MySortObject t) {
				return t.getfName();
			}		    
		};	
		emp.stream().sorted(Comparator.comparing(keyExtractor)).forEach(p -> System.out.println(p.getfName()) );
		emp.stream().sorted(Comparator.comparing(keyExtractor).reversed()).forEach(p -> System.out.println(p.getfName()) );
		
				
		Function<MySortObject, String> getFieldToSort2 = MySortObject::getfName;
		emp.stream().sorted(Comparator.comparing(getFieldToSort2).reversed()).forEach(p -> System.out.println(p.getfName()) );
		emp.stream().sorted(Comparator.comparing(MySortObject::getfName).reversed()).forEach(p -> System.out.println(p.getfName()) );
						
		emp.stream().sorted(Comparator.comparing(MySortObject::getfName).reversed().thenComparing(MySortObject::getlName)).forEach(p -> System.out.println(p.getfName()+" "+p.getlName()) );
		
				
		
				
		
	}

	@Override
	public int compareTo(MySortObject o) {
		return this.getfName().compareTo(o.getfName());
	}

}
