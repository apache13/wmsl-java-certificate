package com.wealth.certificate.dumps_1z0_808.question104;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2014, 6, 20);
		LocalDate date3 = LocalDate.parse("2014-06-20", DateTimeFormatter.ISO_DATE);
		System.out.println("date1 = " + date1);
		System.out.println("date2 = " + date2);
		System.out.println("date3 = " + date3);

		//Date
		System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
		//Time
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); 
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
	}
}
