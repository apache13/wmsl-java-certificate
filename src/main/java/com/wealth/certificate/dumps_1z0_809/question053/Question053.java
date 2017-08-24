package com.wealth.certificate.dumps_1z0_809.question053;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question053 {

	public static void main(String[] args) {
		Path source = Paths.get("/data/december/log.txt");
		Path destination = Paths.get("/data");
		Files.copy(source, destination);

	}

}
