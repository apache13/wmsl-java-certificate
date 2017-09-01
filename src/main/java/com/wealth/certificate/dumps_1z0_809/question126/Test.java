package com.wealth.certificate.dumps_1z0_809.question126;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.stream.Stream;

public class Test
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home")));
		files.forEach(fName -> { // line n1
			try {
				Path aPath = fName.toAbsolutePath(); // line n2
				System.out.println(fName + ":" + Files.readAttributes(aPath, BasicFileAttributes.class /* Wrong : Basic.File.Attributes.class */).creationTime());
			} catch (IOException ex){
				ex.printStackTrace();
			}
		});
	}

	/*
	 * A. All files and directories under the home directory are listed along with their attributes.
	 * > Correct : Print All files and directories under the home directory
	 * B. A compilation error occurs at line n1.
	 * > No compile errors at line n1.
	 * C. The files in the home directory are listed along with their attributes.
	 * > Incorrect : Not print only files but print directories too.
	 * D. A compilation error occurs at line n2.
	 * > No compile errors at line n2.
	 */
}
