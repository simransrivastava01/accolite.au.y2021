package com.accolite.au.y2021.mt._4threadjoin;

/**
 * 
 * @author sree
 *
 */
public class ThreadJoin {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		
		// Utility method to create a Thread of type LongRunning
		Thread longRunningT = LongRunningRunnable.getThreadInstance("LongRunning");
		
		// TODO Sree: Topic, When JVM exits?
		// TODO Sree: Topic Zombie process/thread.
		//longRunningT.setDaemon(true);
		
		longRunningT.start();
		
		/*longRunningT asking main thread to join him. In other words, longRunningT asking main to wait until he completes.*/
		longRunningT.join();
		
		Thread longRunningT2 = LongRunningRunnable.getThreadInstance("LongRunning2");
		longRunningT2.start();
		
		longRunningT2.join();
		
		System.out.println(Thread.currentThread().getName() + " -- Completed.");
	}
}
