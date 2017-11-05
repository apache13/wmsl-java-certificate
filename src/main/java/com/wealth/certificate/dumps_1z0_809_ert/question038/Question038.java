package com.wealth.certificate.dump_1z0_809_72.question038;

import java.util.Locale;
import java.util.ResourceBundle;

public class Question038 {

	public static void main(String[] args) {
		Locale currentLocale;
		// line 1
		/* A --> wrong
		 * The method getInstance(BaseLocale, LocaleExtensions) 
		 * in the type Locale is not applicable for the arguments (Locale, Locale) 
		 */
		//currentLocale = Locale.getInstance(Locale.GERMAN,Locale.GERMANY) ;
		
		/* B
		 * 
		 */
		//currentLocale = Locale.GERMAN;
		
		/* C --> correct
		 * add .build() to return Locale class
		 */
//		currentLocale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
		
		/* D --> correct
		 * 
		 */
		currentLocale = new Locale("de","DE");
		
		/* E
		 * 
		 *
		currentLocale = new Locale(); // no no-args constructor
		currentLocale.setLanguage("de"); // no method, must use Builder instead
		currentLocale.setRegion("DE"); // no method, must use Builder instead
		 */
		
		ResourceBundle messages = ResourceBundle.getBundle(getPackagePath()+".MessagesBundle", currentLocale);
		System.out.println(messages.getString("inquiry"));
	}
	
	private static String getPackagePath(){
		return "com.wealth.certificate.dump_1z0_809_72.question038";
	}
	
}
