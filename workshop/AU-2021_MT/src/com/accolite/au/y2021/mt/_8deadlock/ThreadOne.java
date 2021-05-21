package com.accolite.au.y2021.mt._8deadlock;

/**
 * 
 * @author sree 
 * Bad way of creating thread task, we should always implement runnable.
 */
public class ThreadOne extends Thread {

	private Lock s1;
	private Lock s2;

	public ThreadOne(Lock s1, Lock s2, String name) {
		this.s1 = s1;
		this.s2 = s2;
		setName(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		s1.syncOne(s2);
		System.out.println(Thread.currentThread().getName() + " -- Ended.");
	}
}
