package com.accolite.au.y2021.mt._91advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author sree
 *
 */
public class LatchSampleCallable implements Callable<String> {
	
	private final CountDownLatch cl;
	
	public LatchSampleCallable(CountDownLatch cl) {
		this.cl = cl;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " -- in call. Going to await; latch size:" + cl.getCount());
		cl.countDown();
		Thread.sleep(2000);
		return Thread.currentThread().getName();
	}
}
