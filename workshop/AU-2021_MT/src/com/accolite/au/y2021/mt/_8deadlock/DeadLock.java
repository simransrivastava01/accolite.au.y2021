package com.accolite.au.y2021.mt._8deadlock;

/**
 * 
 * @author sree
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " -- starts.");
		Lock s1 = new Lock();
		Lock s2 = new Lock();

		ThreadOne t1 = new ThreadOne(s1, s2, "One");
		ThreadTwo t2 = new ThreadTwo(s1, s2, "Two");

		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + " -- ends.");
	}
}
