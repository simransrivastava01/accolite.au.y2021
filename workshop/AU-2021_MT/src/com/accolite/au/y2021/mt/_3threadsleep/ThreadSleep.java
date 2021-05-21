package com.accolite.au.y2021.mt._3threadsleep;

/**
 * 
 * @author sree
 *
 */
public class ThreadSleep {
	public static void main(String[] args) throws InterruptedException {
		
		long startedAt = System.currentTimeMillis();
		System.out.println("Main starts -- " + startedAt);
		
		Thread.sleep(5000);
		
		long wokeUpAt = System.currentTimeMillis();
		System.out.println("Main woke up at -- " + wokeUpAt);
		
		System.out.println("Main ends -- total time taken : " + (wokeUpAt - startedAt));
	}
}
