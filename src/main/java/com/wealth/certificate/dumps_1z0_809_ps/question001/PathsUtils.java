package com.wealth.certificate.dumps_1z0_809_ps.question001;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsUtils {
	public static Path getPathFromClass(Class c, String resourceName) {
		URL classPath = c.getResource(".");
		String resource = classPath.toString() + resourceName;
		URI resourceUri = URI.create(resource);
		Path resourcePath = Paths.get(resourceUri);
		//System.out.println("Get : " + resourcePath);
		return resourcePath;

	}
}
