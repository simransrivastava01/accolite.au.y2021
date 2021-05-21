package com.accolite.au.y2021.mt.evaluation.adishi.q2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceFibonacci implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

	public static void main(String args[]) throws ExecutionException, InterruptedException {
		int n;
		System.out.println("Enter how many fibonacci numbers you want to print");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		// Get ExecutorService from Executors utility class, thread pool size is n
		ExecutorService executor = Executors.newFixedThreadPool(n);
		// create a list to hold the Future object associated with Callable
		List<Future<String>> list = new ArrayList<Future<String>>();
		// Create MyCallable instance
		Callable<String> callable = new ExecutorServiceFibonacci();

		for (int i = 0; i < n; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<String> future = executor.submit(callable);
			// add Future to the list, we can get return value using Future
			list.add(future);
		}

		for (int i = 0; i <= n - 1; ++i) {
			// print the return value of Future, notice the output delay in console
			// because Future.get() waits for task to get completed
			Future<String> future = executor.submit(callable);
			System.out.println(fibonacciNumber(i) + "::" + future.get());
		}

		// shut down the executor service now
		executor.shutdown();
	}

	public static int fibonacciNumber(int n) {

		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
	}

	public static void printReport(int number, Future future) {
		try {
			System.out.println(number + "::" + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
