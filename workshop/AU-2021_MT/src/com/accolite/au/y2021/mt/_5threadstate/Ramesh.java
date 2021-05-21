
/**
 * 
 * @author sree
 *
 */
package com.accolite.au.y2021.mt._5threadstate;

public class Ramesh implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -- Ramesh's day starts; STATE - " + NewRunnableWaitiingTerminated.ramesh.getState());
		try {
			System.out.println(Thread.currentThread().getName() + " -- Ramesh's sleeps again for some more time");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + " -- Ramesh wakes up & checks Suresh's STATE -" + NewRunnableWaitiingTerminated.suresh.getState());
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
