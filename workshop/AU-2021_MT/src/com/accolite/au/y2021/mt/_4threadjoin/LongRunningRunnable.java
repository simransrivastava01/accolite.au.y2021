package com.accolite.au.y2021.mt._4threadjoin;

/**
 * 
 * @author sree
 *
 */
public class LongRunningRunnable implements Runnable {

	static Thread getThreadInstance(String name) {
		return new Thread(new LongRunningRunnable(), name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -- Completed.");
	}
}
