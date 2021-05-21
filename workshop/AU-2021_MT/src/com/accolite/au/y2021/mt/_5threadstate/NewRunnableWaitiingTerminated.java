package com.accolite.au.y2021.mt._5threadstate;

import java.lang.Thread.State;

/**
 * 
 * @author sree
 *
 */

public class NewRunnableWaitiingTerminated {

	static Thread ramesh = new Thread(new Ramesh(), "Ramesh");
	static Thread suresh = new Thread(new Suresh(), "Suresh");
	
	/* Story: Suresh & Ramesh are close friends, and Suresh has a Robot who makes sure these guys goes to school every day.*/
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread.currentThread().setName("ROBO");
		
		/** Suresh's day starts when alarm kicks in**/
		System.out.println(Thread.currentThread().getName() + " -- Suresh's day about to start; STATE - " + suresh.getState());
		suresh.start();
		System.out.println(Thread.currentThread().getName() + " -- Suresh's day started; STATE - " + suresh.getState());
		
		System.out.println(Thread.currentThread().getName() + " -- ROBO keeps on checking if both the friends are heading & reaches the school.");
		// TODO Sree: Topic: Busy spinning.
		while(true) {
			if (suresh.getState() == State.TERMINATED && ramesh.getState() == State.TERMINATED ) {
				break;
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " -- Suresh's STATE - " + suresh.getState());
		System.out.println(Thread.currentThread().getName() + " -- Ramesh's STATE - " + ramesh.getState());
		
		System.out.println(Thread.currentThread().getName() + " All Good, see you tomorrow :-)");
	}
}
