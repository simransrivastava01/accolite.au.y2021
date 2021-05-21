package com.accolite.au.y2021.mt._5threadstate;

/**
 * 
 * @author sree
 *
 */
public class Suresh implements Runnable {

	@Override
	public void run() {
		try {

			
			System.out.println(Thread.currentThread().getName() + " -- Suresh checks STATE of Ramesh - " + NewRunnableWaitiingTerminated.ramesh.getState());

			/*Suresh calls Ramesh up, and making him his day started*/
			NewRunnableWaitiingTerminated.ramesh.start();
			System.out.println(Thread.currentThread().getName() + " -- Suresh makes Ramesh's day started; STATE of Ramesh - " + NewRunnableWaitiingTerminated.ramesh.getState());

			System.out.println(Thread.currentThread().getName() + " -- Suresh wants tp sleep again for some time");
			Thread.sleep(2000);

			System.out.println(Thread.currentThread().getName() + " -- Suresh wakes up & checks State of Ramesh - " + NewRunnableWaitiingTerminated.ramesh.getState());

			System.out.println(Thread.currentThread().getName() + " -- Suresh sees that Ramesh slept again. Now Suresh sends a message asking Ramesh to join him on the way");
			NewRunnableWaitiingTerminated.ramesh.join();
			
			System.out.println(Thread.currentThread().getName() + " -- Ramesh Joined, Lets go to School. ");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}