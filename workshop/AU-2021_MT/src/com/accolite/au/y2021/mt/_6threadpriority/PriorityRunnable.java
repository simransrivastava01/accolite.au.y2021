package com.accolite.au.y2021.mt._6threadpriority;

/**
 * 
 * @author sree
 *
 */
public class PriorityRunnable implements Runnable {

	
	static Thread getThreadInstance(String name, int priority) {
		Thread thread = new Thread(new PriorityRunnable(), name);
		thread.setPriority(priority);
		return thread;
	}
	
	static Thread getThreadInstance(String name) {
		return new Thread(new PriorityRunnable(), name);
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + " -- Hello world!, my assignd priority was - " + currentThread.getPriority());
	}
}
