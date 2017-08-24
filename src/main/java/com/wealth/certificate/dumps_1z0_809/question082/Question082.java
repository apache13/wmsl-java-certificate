package com.wealth.certificate.dumps_1z0_809.question082;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Folder {// line n1
	// line n2
	public void open() {
		System.out.print("Open");
	}
}

public class Question082 {
	public static void main(String[] args) throws Exception {
		try (Folder f = new Folder()) {
			f.open();
		}
	}
}
