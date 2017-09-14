package com.wealth.certificate.study_1z0_809.chapter05;

public class ExEnumTest01 {
	enum PrinterType {
	    DOTMATRIX, INKJET, LASER
	}

	PrinterType printerType;

	public ExEnumTest01(PrinterType pType) {
	        printerType = pType;
	    }

	public void feature() {
	        switch(printerType){
	        case DOTMATRIX:
	                System.out.println("Dot-matrix printers");
	                break;
	        case INKJET:
	                System.out.println("Inkjet printers");
	                break;
	        case LASER:
	                System.out.println("Laser printers");
	                break;
	        }
	}

	public static void main(String[] args) {
		ExEnumTest01 enumTest = new ExEnumTest01(PrinterType.LASER);
		enumTest.feature();
		
		PrinterType type = PrinterType.DOTMATRIX; // equivalent to invoke the name()
		PrinterType type2 = PrinterType.valueOf("DOTMATRIX");
		//PrinterType type3 = PrinterType.valueOf("DotmatriX"); // Run-time exception
		
		
		System.out.println(PrinterType.INKJET); 
		// equivalent to invoke the name()
		System.out.println(PrinterType.INKJET.name());
		// in other words 
		System.out.println(PrinterType.INKJET.toString());
		
		System.out.println(type2);
		
	}
}
