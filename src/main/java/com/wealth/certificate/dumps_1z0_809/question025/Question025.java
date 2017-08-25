package com.wealth.certificate.dumps_1z0_809.question025;

import java.io.File;
import java.io.IOException;

public class Question025 {

//	public static void main(String[] args) throws IOException {
//		Question025 q = new Question025();
//		q.recDelete("dir_name");
//	}

	public void recDelete(String dirName) throws IOException {
		File[] listOfFiles = new File(dirName).listFiles();
		if (listOfFiles != null && listOfFiles.length > 0) {
			for (File aFile : listOfFiles) {
				if (aFile.isDirectory()) {
					recDelete(aFile.getAbsolutePath());
				} else {
					if (aFile.getName().endsWith(".class"))
						aFile.delete();
				}
			}
		}
	}

}
