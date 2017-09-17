package com.wealth.certificate.study_1z0_809.chapter17.stream07;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

class Item {

	private String name;
	private double price;
	private Locale madeIn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Locale getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(Locale madeIn) {
		this.madeIn = madeIn;
	}

	public Item(String name, double price, Locale madeIn) {
		this.name = name;
		this.price = price;
		this.madeIn = madeIn;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.price+":"+this.madeIn;
	}
}

public class GroupingBy {

	public static void main(String[] args) {

		/*
		 * 1. groupingBy(Function) 
		 * 2. groupingBy(Function, Collector) 
		 * 3. groupingBy(Function, Supplier, Collector)
		 */

		List<Item> words = Arrays.asList(
				new Item[] { new Item("A", 80.0, Locale.US), new Item("B", 60.0,Locale.US), new Item("C", 30.0,Locale.CHINA), new Item("D", 60.0,Locale.JAPAN) });

		{
			Map<Locale, List<Item>> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn()));
			System.out.println(list);
		}
		
		{
			Map<Locale, List<Item>> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn(), Collectors.toList()));
			System.out.println(list);
		}
		
		{
			Map<Locale, Long> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn(), Collectors.counting()));
			System.out.println(list);
		}
		
		{
			Map<Locale, Double> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn(), Collectors.<Item>summingDouble(i->i.getPrice())));
			System.out.println(list);
		}
		
		{
			Map<Locale, Double> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn(), Collectors.<Item>averagingDouble(i->i.getPrice())));
			System.out.println(list);
		}
		
		{
			Map<Locale, DoubleSummaryStatistics> list = words.stream()
					.collect(Collectors.groupingBy(e -> e.getMadeIn(), Collectors.<Item>summarizingDouble(i->i.getPrice())));
			System.out.println(list);
		}

	}

}
