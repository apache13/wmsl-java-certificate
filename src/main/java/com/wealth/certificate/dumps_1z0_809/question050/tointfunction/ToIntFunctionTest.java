package com.wealth.certificate.dumps_1z0_809.question050.tointfunction;

import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class ToIntFunctionTest {
	public static final String str = "Oh My God!"; 
	
	public static <T> int testToIntFunction(T value) {
		return str.indexOf(value.toString());
	}
	
	public static <T> int testToIntBiFunction(T value1 ,T value2) {
		return value1.toString().compareTo(value2.toString());
	}
	
	public static void main(String[] args) {
		
		System.out.println("ToIntFunction (1 arg and 1 return int) --> applyAsInt method");
		//1. new implement ToIntFunction;
		ToIntFunction<String> testTIFImpl = new ToIntFunction<String>() {
			@Override
			public int applyAsInt(String value) {
				return str.indexOf(value);
			}
		};
		
		//2. lampda with ToIntFunction
		ToIntFunction<String> testTIFLampda = x -> str.indexOf(x);
		
		//3. lampda with ToIntFunction Method
		ToIntFunction<String> testTIFLampdaMethod = x -> testToIntFunction(x);
		
		//4. method reference with ToIntFunction
		ToIntFunction<String> testTIFMethodRef = str::indexOf;
		
		//5. method reference with ToIntFunction Method
		ToIntFunction<String> testTIFMethodRefWithMethod = ToIntFunctionTest::testToIntFunction;
		
		int toIntFunction1 = testTIFImpl.applyAsInt("God");
		int toIntFunction2 = testTIFLampda.applyAsInt("God");
		int toIntFunction3 = testTIFLampdaMethod.applyAsInt("God");
		int toIntFunction4 = testTIFMethodRef.applyAsInt("God");
		int toIntFunction5 = testTIFMethodRefWithMethod.applyAsInt("God");
		
		System.out.println("testTIFImpl : "+toIntFunction1);
		System.out.println("testTIFLampda : "+toIntFunction2);
		System.out.println("testTIFLampdaMethod : "+toIntFunction3);
		System.out.println("testTIFMethodRef : "+toIntFunction4);
		System.out.println("testTIFMethodRefWithMethod : "+toIntFunction5);
		
		System.out.println();
		//===================================================================================
		
		System.out.println("ToIntBiFunction (2 arg and 1 return int) --> applyAsInt method");
		//1. new implement ToIntBiFunction;
		ToIntBiFunction<String,String> testTIBFImpl = new ToIntBiFunction<String, String>() {
			
			@Override
			public int applyAsInt(String a, String b) {
				return a.compareTo(b);
			}
		};
		
		//2. lampda with ToIntFunction
		ToIntBiFunction<String,String> testTIBFLampda = (x,y) -> x.compareTo(y);
		
		//3. lampda with ToIntFunction Method
		ToIntBiFunction<String,String> testTIBFLampdaMethod = (x,y) -> testToIntBiFunction(x,y);
		
		//4. method reference with ToIntFunction Method
		ToIntBiFunction<String,String> testTIBFMethodRefWithMethod = ToIntFunctionTest::testToIntBiFunction;
		
		int toIntBiFunction1 = testTIBFImpl.applyAsInt("Test1","Test1");
		int toIntBiFunction2 = testTIBFLampda.applyAsInt("Test1","Test1");
		int toIntBiFunction3 = testTIBFLampdaMethod.applyAsInt("Test1","Test1");
		int toIntBiFunction4 = testTIBFMethodRefWithMethod.applyAsInt("Test1","Test1");
		
		System.out.println("testTIBFImpl : "+toIntBiFunction1);
		System.out.println("testTIBFLampda : "+toIntBiFunction2);
		System.out.println("testTIBFLampdaMethod : "+toIntBiFunction3);
		System.out.println("testTIBFMethodRefWithMethod : "+toIntBiFunction4);
	}

}
