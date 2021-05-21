package com.accolite.au.y2021.mt._1createthread;

/**
 * 
 * @author sree
 *
 */
public class CreateThreadByImplementingRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Ran as a thread - thread name : " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		System.out.println("Main started - thread name : " + Thread.currentThread().getName());
		Thread t = new Thread(new CreateThreadByImplementingRunnable());
		//t.run();
		t.start();
	}
}
