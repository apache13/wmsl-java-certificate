package com.wealth.certificate.dumps_1z0_809.question024;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class Question24 {



	public static void main(String[] args) {
		Instant first = Instant.now();

		// wait some time while something happens

		Instant second = Instant.now();

		Duration duration = Duration.between(first.plusSeconds(100), second);
		
		System.out.println(duration);
		
		Duration duration2 = Duration.between(LocalDateTime.now().plusSeconds(70), LocalDateTime.now());

		System.out.println(duration2); //PT-1M-10S
		
	}

}
