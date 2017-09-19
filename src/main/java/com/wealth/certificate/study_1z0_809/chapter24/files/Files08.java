package com.wealth.certificate.study_1z0_809.chapter24.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class Files08 {
	public static void main(String[] args) {
		try {
			Path in = Paths.get(Files01.getCurrentPath() + "\\temp\\dir1\\in.txt");
			Path out = Paths.get(Files01.getCurrentPath() + "\\temp\\dir2\\out.txt");

			Path result = Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

			BasicFileAttributes basicIn = Files.readAttributes(in, BasicFileAttributes.class);

			BasicFileAttributes basicOut = Files.readAttributes(out, BasicFileAttributes.class);

			DosFileAttributes dosIn = Files.readAttributes(in, DosFileAttributes.class);

			DosFileAttributes dosOut = Files.readAttributes(out, DosFileAttributes.class);

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
