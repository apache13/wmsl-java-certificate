package com.wealth.certificate.study_1z0_809.chapter05;

public class ExEnumTest02 {
	
	public static void main(String[] args) {
		//System.out.println(Volume.HIGH);
//		System.out.println(Volume.LOW.ordinal());
//		Volume level = Volume.valueOf("LOW");
//		System.out.println(Volume.valueOf("LOW").values()[0].getValue());
		
		for(Volume v: Volume.values()) {
			   System.out.print(v + ", ");
				switch(v) {
			        case HIGH: System.out.println(1); break;
			        case MEDIUM: System.out.println(2); break;
			        case LOW: System.out.println(3); break;
				}
			}
		
//		Volume l1 = Volume.HIGH;
//		Volume l2 = Volume.HIGH;
		
	}

}
