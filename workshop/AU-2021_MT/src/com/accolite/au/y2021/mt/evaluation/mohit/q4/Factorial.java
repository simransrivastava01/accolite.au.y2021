package com.accolite.au.y2021.mt.evaluation.mohit.q4;
/*
   Q4)
   Print Factorial series.
	- Each number in the series should be printed by a unique thread.
	- Do not use anything from the concurrent package. 
	- After the series is printed, a report should be printed displaying which thread(name) printed which number.
*/
/*
 * 
 * @author: Mohit Sharma  
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

class Report {

	private long factorial;
	private String threadName;
	private int activeThreads;

	public Report(long factorial, String threadName, int activeThreads) {
		this.factorial = factorial;
		this.threadName = threadName;
		this.activeThreads = activeThreads;
	}

	public long getFactorial() {
		return factorial;
	}

	public String getThreadName() {
		return threadName;
	}

	public int getActiveThreads() {
		return activeThreads;
	}

	public void setActiveThreads(int activeThreads) {
		this.activeThreads = activeThreads;
	}

}

public class Factorial implements Runnable {

	public static ArrayList<Report> report = new ArrayList<Report>();
	private static int count;

	public static void main(String[] args) throws InterruptedException {

		Scanner in = new Scanner(System.in);

		System.out.print("N: ");
		int n = in.nextInt();
		
		count = n;
		
		Factorial f = new Factorial();
		f.series(n);
		
		// Series
		for(Report r : report) {
			if(r.getFactorial() == 1) {
				System.out.print(r.getFactorial());
			}
			else {
				System.out.print(r.getFactorial() + "*");
			}
		}
		
		System.out.println();
		
		// Report
		for(Report r : report) {
			System.out.println(r.getFactorial() + " printed by " + r.getThreadName() + " " + r.getActiveThreads());
		}
		
		in.close();
	}
	
	public void series(int n) throws InterruptedException {
		for(int i=0;i<n;i++) {
			Thread t = new Thread(new Factorial());
			t.start();
		}
	}
	
	public synchronized void generate() throws InterruptedException {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		report.add(new Report(count--, Thread.currentThread().getName(), threadGroup.activeCount()));
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				generate();
				notify();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
					wait();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Factorial.count = count;
	}

}