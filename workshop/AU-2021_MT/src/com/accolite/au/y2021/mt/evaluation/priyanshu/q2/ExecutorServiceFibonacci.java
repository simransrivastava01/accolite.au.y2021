package com.accolite.au.y2021.mt.evaluation.priyanshu.q2;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// Review: Sree -- Are you kidding? - this is not at all a multi threading program. Each number should be printed by a thread.
public class ExecutorServiceFibonacci implements Callable<String> {
	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName();
	}


    public static int fib(int n) {

		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return fib(n - 1) + fib(n - 2);
	}

	public static void main(String args[]) throws ExecutionException, InterruptedException {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ExecutorService executor = Executors.newFixedThreadPool(n);
		List<Future<String>> list = new ArrayList<Future<String>>();
		Callable<String> callable = new ExecutorServiceFibonacci();

		for (int i = 0; i < n; i++) {
			Future<String> future = executor.submit(callable);
			list.add(future);
		}


        for (int i = 0; i <= n - 1; ++i) {
			Future<String> future = executor.submit(callable);
			System.out.println(fib(i));
		}

		for (int i = 0; i <= n - 1; ++i) {
			Future<String> future = executor.submit(callable);
			System.out.println(fib(i) + "=>" + future.get());
		}

		executor.shutdown();
	}

}