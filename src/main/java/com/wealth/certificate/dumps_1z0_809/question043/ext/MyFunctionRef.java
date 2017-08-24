package com.wealth.certificate.dumps_1z0_809.question043.ext;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class MyClass {
	private void function1() {
		System.out.println("function1");
	}

	void function2() {
		System.out.println("function2");
	}

	protected void function3() {
	}

	public void function4() {
	}

	private static void sfunction1() {
	}

	static void sfunction2() {
	}

	static protected void sfunction3() {
	}

	static public void sfunction4() {
		System.out.println("Hello sfunction4");
	}

	final public void ffunction5() {
	}
	
	public void functionConsumer() {
		System.out.println("functionConsumer "+this);
	}

	public void functionBiConsumer(String msg) {
		System.out.println("functionBiConsumer " + msg);
	}
	
	public String functionFunction() {
		System.out.println("Function");
		return null;
	}
	
	public String functionBiFunction(String msg) {
		System.out.println("BiFunction "+msg);
		return null;
	}
	
}

public class MyFunctionRef {

	public static void testSupplier(Supplier<MyClass> supplier) {
		MyClass myClass = supplier.get();
		System.out.println(myClass);
	}
	
	public static void testConsumer(Consumer<MyClass> consumer) {
		consumer.accept(new MyClass());
	}
	
	public static void testBiConsumer(BiConsumer<MyClass,String> consumer) {
		consumer.accept(new MyClass(),"BiConsumer");
	}
	
	public static void testFunction(Function<MyClass,String> function) {
		function.apply(new MyClass());
	}
	
	public static void main(String[] args) {

		// 0 arg and 1 return -- get
		Supplier<MyClass> supplier = new Supplier<MyClass>() {
			@Override
			public MyClass get() {
				return new MyClass();
			}
		};		
		Supplier<MyClass> supplierRef = MyClass::new;
		//testSupplier(supplier);
		//testSupplier(supplierRef);					
		//testSupplier(MyClass::new); 				// method expression
		//testSupplier(()->new MyClass());		 	// lambda expression

	
		// 1 arg and 0 result --> accept
		Consumer<MyClass> consumer = new Consumer<MyClass>() {
			@Override
			public void accept(MyClass t) {
				System.out.println("Consumer "+t);
			}
		};
		Consumer<MyClass> consumerRef = MyClass::functionConsumer;
		
		//testConsumer(consumer);
		//testConsumer(consumerRef);
		//testConsumer(MyClass::functionConsumer);
		//testConsumer((MyClass m)->System.out.println("Lambda Consumer "+m));			
		//Consumer<PrintStream> print = System.out::println;
		
		
		// 2 args and 0 return --> accept
		BiConsumer<MyClass, String> biConsumer = new BiConsumer<MyClass, String>() {
			@Override
			public void accept(MyClass t, String u) {
				System.out.println("BiConsumer");
			}
		};
		BiConsumer<MyClass, String> biConsumerRef = MyClass::functionBiConsumer;
		
		testBiConsumer(biConsumer);
		testBiConsumer(biConsumerRef);
		testBiConsumer(MyClass::functionBiConsumer);
		testBiConsumer((MyClass m,String s)->{});

		
		
		// 1 arg and 1 return --> apply
		Function<MyClass, String> function = new Function<MyClass, String>() {
			@Override
			public String apply(MyClass t) {
				return "Function";
			}
		};
		Function<MyClass, String> functionRef = MyClass::functionFunction;
		functionRef.apply(new MyClass());
		
		// 2 args and 1 return --> apply
		BiFunction<MyClass, MyClass, String> biFunction = new BiFunction<MyClass, MyClass, String>() {
			@Override
			public String apply(MyClass t, MyClass u) {
				return "BiFunction";
			}
		};
		BiFunction<MyClass, String, String> biFunctionRef = MyClass::functionBiFunction;
		biFunctionRef.apply(new MyClass(), "Hello");
		
		
		

		
		// 0 arg and 0 return
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("Runnable");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
		// Method expression
		runnable = MyClass::sfunction4;
		thread = new Thread(runnable);
		thread.start();
		
		// lambda expression
		thread = new Thread(()->System.out.println("Runnable")) ;
		thread.start();
	}

}
