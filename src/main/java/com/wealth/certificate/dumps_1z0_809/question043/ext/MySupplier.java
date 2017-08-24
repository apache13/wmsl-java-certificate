package com.wealth.certificate.dumps_1z0_809.question043.ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class MyList extends ArrayList{	
	public void print() {
		this.stream().forEach(p->System.out.println(p));
	}
}

public class MySupplier {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Supplier<MyList> supplier = new Supplier<MyList>() {			
			@Override
			public MyList get() {				
				return new MyList();
			}
		};		
		
		BiConsumer<MyList,Integer> accumulator = new BiConsumer<MyList, Integer>() {
			@Override
			public void accept(MyList myList, Integer element) {
				myList.add(element);
			}
		};		
		
		BiConsumer<MyList,MyList> combiner = new BiConsumer<MyList, MyList>() {
			@Override
			public void accept(MyList m1, MyList m2) {
				m1.addAll(m2);
			}
		};
		
		// function ref
		list.stream().collect(supplier, accumulator, combiner).print();
		
		// lambda
		list.stream().collect(()->{return new MyList();}, (MyList m,Integer e) -> m.add(e) , (MyList m1,MyList m2)-> m1.addAll(m2)).print();
		
		
		list.stream().collect(Collectors.toList()).forEach(p->System.out.println(p));
	
	}

}
