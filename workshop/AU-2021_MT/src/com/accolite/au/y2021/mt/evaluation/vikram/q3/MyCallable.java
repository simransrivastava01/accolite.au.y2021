package com.accolite.au.y2021.mt.evaluation.vikram.q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 
 * Question ::  Demonstrate DeadLock.
 *			- Use, ExecutorService, Callable & Future
 *
 * @author Vikram 
 * 
 */

public class MyCallable {
public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " -- starts.");
		Lock s1 = new Lock();
		Lock s2 = new Lock();
		
		Thread1 t1 = new Thread1(s1, s2);
		Thread2 t2 = new Thread2(s1, s2);
		
		ExecutorService ex=Executors.newFixedThreadPool(2);
		
//		t1.start();
//		t2.start();
		
		Future<String> f1=ex.submit(t1);
		Future<String> f2=ex.submit(t2);
		
		System.out.println(f1 + "  " + f2);
		
		System.out.println(Thread.currentThread().getName() + " -- ends.");
	}
}
