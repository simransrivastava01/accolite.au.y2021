package com.accolite.au.y2021.mt.evaluation.vikram.q3;
import java.util.concurrent.Callable;


public class Thread1 implements Callable<String> {
	private static Lock s1;
	private static Lock s2;
	
	public Thread1() {
		
	}

	public Thread1(Lock s1, Lock s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
//	public static void start() {
//		
//		ExecutorService ex=Executors.newSingleThreadExecutor();
//		
//		Callable<String> callable =  new Thread1();
//		List<Future<String>> list = new ArrayList<Future<String>>();
//		
//		Future<String> future = ex.submit(callable);
//		
//	}
	

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		s1.syncOne(s2);
		
		System.out.println(Thread.currentThread().getName() + " -- Ended.");
		return "cde";
	}
}
