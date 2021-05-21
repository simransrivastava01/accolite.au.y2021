package com.accolite.au.y2021.mt._1createthread;

/**
 * 
 * @author sree
 * 
 * This is the not the preferred way of doing it.
 * 
 */
public class CreateThreadByExtendingThread extends Thread {

	public static void main(String[] args) {
		System.out.println("Main started - thread name : " + Thread.currentThread().getName());		
		CreateThreadByExtendingThread t1 = new CreateThreadByExtendingThread();
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Ran as a thread - thread name : " + Thread.currentThread().getName());
	}
}
