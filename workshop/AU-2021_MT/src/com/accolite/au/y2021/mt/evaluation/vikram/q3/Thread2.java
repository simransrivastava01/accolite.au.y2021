package com.accolite.au.y2021.mt.evaluation.vikram.q3;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;



public class Thread2 implements Callable<String> {
	private static Lock s1;
	private static Lock s2;
	
	public Thread2() {
		
	}


	public Thread2(Lock s1, Lock s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
//	public static void start() {
//		
//		ExecutorService ex=Executors.newSingleThreadExecutor();
//		
//		Callable<String> callable =  new Thread2();
//		List<Future<String>> list = new ArrayList<Future<String>>();
//		
//		Future<String> future = ex.submit(callable);
//		
//	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		s2.syncTwo(s1);
		System.out.println(Thread.currentThread().getName() + " -- Ended.");
		return "abc";
	}
}
