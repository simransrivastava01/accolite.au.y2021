package com.accolite.au.y2021.mt._8deadlock;

/**
 * 
 * @author sree
 *
 */
public class Lock {

	synchronized void syncOne(Lock s2) {
		System.out.println(Thread.currentThread().getName() + " -- syncOne starts.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println(Thread.currentThread().getName() + " -- Going to invoke s2.syncTwo");
		s2.syncTwo(this);
		
		System.out.println(Thread.currentThread().getName() + " -- syncOne ends.");
	}

	synchronized void syncTwo(Lock s1) {
		System.out.println(Thread.currentThread().getName() + " -- syncTwo starts.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		
		System.out.println(Thread.currentThread().getName() + " -- Going to invoke s1.syncOne");
		s1.syncOne(this);
		
		System.out.println(Thread.currentThread().getName() + " -- syncTwo ends.");
	}
}
