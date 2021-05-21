package com.accolite.au.y2021.mt._7cuncurrency;

public class WaitNotifySyncBlock {

	public static void main(String[] args) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " -- Started.");

		Object lock = new Object();

		Thread l1 = LockingRunnable.getThreadInstance("First - Locker", lock);
		Thread l2 = LockingRunnable.getThreadInstance("Second - Locker", lock);

		Thread u1 = UnlockingRunnable.getThreadInstance("First Unlocker", lock);
		Thread u2 = UnlockingRunnable.getThreadInstance("Second Unlocker", lock);

		// Sree TODO: what happens step by step? !!RPic
		l1.start();
		l2.start();
		
		u1.start();
		u2.start();
	}
}
