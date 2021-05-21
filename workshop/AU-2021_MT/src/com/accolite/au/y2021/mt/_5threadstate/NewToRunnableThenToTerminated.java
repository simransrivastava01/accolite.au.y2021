package com.accolite.au.y2021.mt._5threadstate;

/**
 * 
 * @author sree
 *
 */
public class NewToRunnableThenToTerminated {
	
	//TODO Sree: Theory, Ref Thread.State
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread();
		//ThreadUtils.printStacks(myThread);
		
		System.out.println("Status of main myThread - " + myThread.getState());
		System.out.println("Status of main thread - " + Thread.currentThread().getState());
		
		myThread.start();
		
		System.out.println("Status of main myThread - " + myThread.getState());
		System.out.println("Status of main thread - " + Thread.currentThread().getState());
		
		// Not advisable to do so.
		myThread.stop();
		
		// Thread.sleep(5000);
		
		System.out.println("Status of main myThread - " + myThread.getState());
		System.out.println("Status of main thread - " + Thread.currentThread().getState());
	}
}
