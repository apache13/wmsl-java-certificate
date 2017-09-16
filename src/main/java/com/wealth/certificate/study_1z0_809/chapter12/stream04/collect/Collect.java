package com.wealth.certificate.study_1z0_809.chapter12.stream04.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.wealth.certificate.study_1z0_809.chapter12.stream04.find.Find;

public class Collect {

	public static void printPeek(String s) {
		System.out.println("@"+Thread.currentThread().getId()+"-peek : "+s);
	}
	
	public static void printCombiner(List<Integer> a ,List<Integer> b) {
		System.out.println("printCombiner : "+a+" <> "+b);
		a.addAll(b);
	}
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
		
		/*1. <R,A> R collect(Collector<? super T,A,R> collector)	Performs a mutable reduction operation on the elements of this stream using a Collector.*/
		/*1.1 .collect(supplier, accumulator, combiner)*/
		{
			List<Integer> list = words.stream()
			.peek(Find::printPeek)
			//.parallel()
			.collect(()->new ArrayList<Integer>(), (s,e)->s.add(e.length()) , (a,b)->a.addAll(b));
			//.collect(ArrayList::new, (s,e)->s.add(e.length()) , List::addAll);
			//.collect(ArrayList::new, (s,e)->s.add(e.length()) , Collect::printCombiner);
			System.out.println(list);			
		}
		
		/*1.2 .collect(collector)*/
		/*1.2.1 public static <T> Collector<T,?,List<T>> toList()*/
		{
			List<String> list = words.stream()
			.peek(Find::printPeek)
			//.parallel()
			.collect(Collectors.toList());
			//.collect(Collectors.toCollection(LinkedList::new));
			System.out.println(list);
			System.out.println(list.getClass().toGenericString());
		}
		
		// 1.2.2 public static <T> Collector<T,?,Set<T>> toSet()
		{
			Set<String> set = words.stream()
			.peek(Find::printPeek)
			//.parallel()			
			.collect(Collectors.toSet());
			//.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(set);
			System.out.println(set.getClass().toGenericString());
		}
		
		
		// 1.2.3.1 public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper,Function<? super T,? extends U> valueMapper)
		{				
			//words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao","hello"});			
			Map<String,Integer> map = words.stream()
			.peek(Find::printPeek)
			//.parallel()			
			.collect(Collectors.toMap( k->k,k->k.length()));
			//.collect(Collectors.toMap( Object::toString , String::length));
			System.out.println(map);
		}
		
		// 1.2.3.2 public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper,Function<? super T,? extends U> valueMapper,BinaryOperator<U> mergeFunction)
		{
			words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao","hello"});
			
			BinaryOperator<Integer> mergeFunction = new BinaryOperator<Integer>() {
				@Override
				public Integer apply(Integer t, Integer u) {
					System.out.println("mergeFunction ("+t+" + "+u+")");
					return t+u;
				}
			};
						
			Map<String,Integer> map = words.stream()
			.peek(Find::printPeek)
			//.parallel()			
			.collect(Collectors.toMap(Object::toString,String::length, mergeFunction ));
			System.out.println(map);
			//System.out.println(map.getClass().toGenericString());
		}
		
		// 1.2.3.3 public static <T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(Function<? super T,? extends K> keyMapper,Function<? super T,? extends U> valueMapper,BinaryOperator<U> mergeFunction,Supplier<M> mapSupplier)
		{
			words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao","hello"});
			
			BinaryOperator<Integer> mergeFunction = new BinaryOperator<Integer>() {
				@Override
				public Integer apply(Integer t, Integer u) {
					System.out.println("mergeFunction ("+t+" + "+u+")");
					return t+u;
				}
			};
						
			Supplier<Map<String,Integer>> mapSupplier = new Supplier<Map<String,Integer>>() {
				@Override
				public Map<String,Integer> get() {
					return new LinkedHashMap<String,Integer>();				
				}
			};
			
			Map<String,Integer> map = words.stream()
			.peek(Find::printPeek)
			//.parallel()			
			.collect(Collectors.toMap(Object::toString,String::length, mergeFunction, mapSupplier ));
			System.out.println(map);
			System.out.println(map.getClass().toGenericString());
		}
				
		
	}

}
