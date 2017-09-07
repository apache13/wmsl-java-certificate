<<<<<<< HEAD
package com.wealth.certificate.dumps_1z0_809_ps.question042;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread implements Runnable {
	private static AtomicInteger count = new AtomicInteger (0);
	public void run () {
		int x = count.incrementAndGet();
		System.out.print (x+" ");
	}
}

public class Test
{
	public static void main(String[] args)
	{
		Thread thread1 = new Thread(new MyThread());
		Thread thread2 = new Thread(new MyThread());
		Thread thread3 = new Thread(new MyThread());
		Thread [] ta = {thread1, thread2, thread3};
		for (int x= 0; x < 3; x++) {
			ta[x].start();
		}
		
		/** Answered : B is incorrect, Correct is A print but not ordering because asynchronize thread. **/
	}
}
=======
package com.wealth.certificate.dumps_1z0_809_ps.question042;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread implements Runnable {
	private static AtomicInteger count = new AtomicInteger (0);
	public void run () {
		int x = count.incrementAndGet();
		System.out.print (x+" ");
	}
}

public class Test
{
	public static void main(String[] args)
	{
		Thread thread1 = new Thread(new MyThread());
		Thread thread2 = new Thread(new MyThread());
		Thread thread3 = new Thread(new MyThread());
		Thread [] ta = {thread1, thread2, thread3};
		for (int x= 0; x < 3; x++) {
			ta[x].start();
		}
		
		/** Answered : B is incorrect, Correct is A print but not ordering because asynchronize thread. **/
	}
}
>>>>>>> d66007e32a70cc5b69376e15612021d16704cd6d
