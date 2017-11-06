package com.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class RunnableTask implements Runnable {
    public void run() {
        System.out.println("Running");
    }
}

public class Test {
		
	public static void main(String[] args) throws InterruptedException {
		/*Thread thread = new Thread(new RunnableTask());
		thread.start();*/
		
		/*Thread thread1 = new Thread(new RunnableTask() {
		    public void run() {
		        System.out.println("Running2");
		    }
		 });
		thread1.start();*/
		
		/*ExecutorService executor = Executors.newSingleThreadExecutor();
		Runnable r = () -> {
		    try {
		        Thread.sleep(3_000);
		        System.out.println("start");
		    } catch (InterruptedException e) {
		        System.out.println("Interrupted");
		    }
		};
		executor.execute(r);
		executor.shutdown();*/
		
		
		/*//ExecutorService Runnable
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Runnable r = () -> {
		    IntStream.range(1, 1_000_000_000).forEach(System.out::println);;
		};
		try {
		    // Blocks until the Runnable has finished
			Future<?> future = executor.submit(r);
		    future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException
		    | ExecutionException e) { 
			
		} catch (TimeoutException e) {
			System.out.println("TimeOut");
		}finally {
			executor.shutdown();
		}
		
		//ExecutorService Callable
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		Callable<Long> c = () ->
		    LongStream.rangeClosed(1, 1_000_000_000).sum();
		Future<Long> future1 = executor1.submit(c);
		try {
		    // Blocks 1 second until the Callable has finished
		    Long result = future1.get(1, TimeUnit.SECONDS);
		    System.out.println(result);
		} catch (InterruptedException | ExecutionException
		    | TimeoutException e) { *//** ... *//* 
			
			System.out.println("TimeOut");
		}finally {
			executor1.shutdown();
		}*/
		
		
		/*List<Callable<String>> callables = new ArrayList<>();
		callables.add(() -> "Callable 1");
		callables.add(() -> "Callable 2");
		callables.add(() -> "Callable 3");
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		try {
		    List<Future<String>> futures = executor.invokeAll(callables);
		    for(Future<String> f : futures){
		        System.out.format("%s - %s%n", f.get(), f.isDone());
		    }
		} catch(InterruptedException | ExecutionException e) {  }*/
		
	/*	String[] steps = {	"Read the recipe",
							"Gather the ingredients",
							"Wash hands"};
	      System.out.println("Preparing everything:");
	
	      Runnable allSet = () ->
	         System.out.println( "Everything's ready. Let's begin.");
	
	      ExecutorService executor =
	         Executors.newFixedThreadPool(steps.length);
	      CyclicBarrier barrier =
	         new CyclicBarrier(steps.length, allSet);
	
	      for(String step : steps) {
	         executor.submit(
	            () -> checkStep(barrier, step)
	         );
	      }
	
	      executor.shutdown();*/
		
			      BlockingDeque<Integer> deque =
			            new LinkedBlockingDeque<>();
			      deque.offerLast(10, 5, TimeUnit.SECONDS);
			      System.out.print(
			         deque.pollLast(5, TimeUnit.SECONDS)
			         + " "
			      );
			      System.out.print(
			         deque.pollFirst(5, TimeUnit.SECONDS));

	}
	
	static void checkStep(
            CyclicBarrier barrier, String step) {
      // Do something to prepare the step
      System.out.println(step + " is ready");
      try {
         // Wait the other threads
         barrier.await();
      } catch (Exception e) { /** ... */ }
   }
	

}
