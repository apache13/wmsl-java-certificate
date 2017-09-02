package com.wealth.certificate.dumps_1z0_809.question100;

import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
	CyclicBarrier cb;

	public Worker(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		try {
			cb.await();
			System.out.println("Worker…");
		} catch (Exception ex) {
		}
	}
}

class Master implements Runnable { // line n1
	public void run() {
		System.out.println("Master…");
	}
}

class Test {
	public static void main(String[] args) {
		Master master = new Master();
		// line n2
		Worker worker = new Worker(cb);
		worker.start();
	}
}

/*
You have been asked to ensure that the run methods of both the Worker and Master
classes are executed.

Which modification meets the requirement?

A. At line n2, insert CyclicBarrier cb = new CyclicBarrier(2, master);
B. Replace line n1 with class Master extends Thread {
C. At line n2, insert CyclicBarrier cb = new CyclicBarrier(1, master);
D. At line n2, insert CyclicBarrier cb = new CyclicBarrier(master);
Answer: B

*/
