package com.accolite.au.y2021.mt.common;

/**
 * 
 * @author sree
 *
 */
public class ThreadUtils {

	public static void printStacks(Thread currentThread) {
		// Get the stack of the thread been through so far till now
		StackTraceElement[] stackTrace = currentThread.getStackTrace();
		
		if (stackTrace.length == 0) {
			System.out.println("!!! No stacks available at the moment !!!");
			return;
		}
		
		System.out.println("=========================================================");
		for (int i= stackTrace.length-1; i >= 0; i--) {
			StackTraceElement stEle = stackTrace[i];
			System.out.println((stackTrace.length - i) +  ". " + stEle.toString());
		}
		System.out.println("=========================================================\n");
	}
	
	public static void sleepForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}
