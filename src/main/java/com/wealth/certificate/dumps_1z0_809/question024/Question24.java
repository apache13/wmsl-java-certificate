package com.wealth.certificate.dumps_1z0_809.question024;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Question24 {



	public static void main(String[] args) {
		Instant first = Instant.now();

		// wait some time while something happens

		Instant second = Instant.now(); //MachineTimeStamp

		Duration duration = Duration.between(first.plusSeconds(100), second);
		
		Duration duration2 = Duration.between(LocalDateTime.now().plusSeconds(70), LocalDateTime.now());
		
		System.out.println("Duration :"+duration);
		System.out.println("Duration :"+duration.toDays());
		System.out.println("Duration 2 :"+duration2.toDays()); //PT-1M-10S
		

		//Period
		
		Period tenDays = Period.ofDays(10);
        System.out.println(tenDays.getDays()); //10
        
        Period p2 = Period.between(LocalDate.now().plusDays(70), LocalDate.now());
        System.out.println(p2);
        
        
        //TimeZone
        ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-5"));
		ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-5"));
		long hrs = ChronoUnit.HOURS.between(depart, arrive); // line n1
		
		System.out.println(depart);
		System.out.println(arrive);
		System.out.println("Travel time is" + hrs + "hours");
	}

}

//iso-8601
