package com.wealth.certificate.dumps_1z0_809.question092;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		ResourceBundle bundle1 = ResourceBundle.getBundle(getPackagePath());
		displayValues(bundle1);
		
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle bundle2 = ResourceBundle.getBundle(getPackagePath(), defaultLocale);
		displayValues(bundle2);

		Locale swedishLocale = new Locale("sv", "SE");
		ResourceBundle bundle3 = ResourceBundle.getBundle(getPackagePath(), swedishLocale);
		displayValues(bundle3);
	}
	
	public static void displayValues(ResourceBundle bundle) {
		System.out.println("menu1 message: " + bundle.getString("menu1"));
		System.out.println("menu2 message: " + bundle.getString("menu2"));
		System.out.println();
	}
	
	private static String getPackagePath(){
		return "com.wealth.certificate.dumps_1z0_809.question092.config";
	}
}
