package com.accolite.au.y2021.mt._91advanced;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author sree
 *
 */
public class CLatchSample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CountDownLatch cl = new CountDownLatch(3);
		
		System.out.println(Thread.currentThread().getName() + " -- Starts");
		
		LatchSampleCallable lc1 = new LatchSampleCallable(cl);
		LatchSampleCallable lc2 = new LatchSampleCallable(cl);
		LatchSampleCallable lc3 = new LatchSampleCallable(cl);
		
		ExecutorService tp = Executors.newFixedThreadPool(5);
		
		Future<String> result1 = tp.submit(lc1);
		Future<String> result2 = tp.submit(lc2);
		Future<String> result3 = tp.submit(lc3);
		
		System.out.println("result1 Done? - " + result1.isDone());
		System.out.println("result2 Done? - " + result2.isDone());
		System.out.println("result3 Done? - " + result3.isDone());
		
		while(true) {
			if (result1.isDone() && result2.isDone() && result3.isDone()) {
				System.out.println("result1 - " + result1.get());
				System.out.println("result2 - " + result2.get());
				System.out.println("result3 - " + result3.get());
				break;
			}
		}
		
		cl.await();
		System.out.println(Thread.currentThread().getName() + " -- Ends");
		
		tp.shutdownNow();
	}
}
