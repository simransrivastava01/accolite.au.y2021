package com.accolite.au.y2021.mt.evaluation.vikram.q3;



public class Lock {

	public synchronized void syncOne(Lock s2) {
		System.out.println(Thread.currentThread().getName() + " -- syncOne started.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println(Thread.currentThread().getName() + " -- syncTwo invoked");
		s2.syncTwo(this);
		
		System.out.println(Thread.currentThread().getName() + " -- syncOne ends.");
		
	}

	public synchronized void syncTwo(Lock s1) {
		System.out.println(Thread.currentThread().getName() + " -- syncTwo starts.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		
		System.out.println(Thread.currentThread().getName() + " -- syncOne invoked.");
		s1.syncOne(this);
		
		System.out.println(Thread.currentThread().getName() + " -- syncTwo ends.");
	}
}
