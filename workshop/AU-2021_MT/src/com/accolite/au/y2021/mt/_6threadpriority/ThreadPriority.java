package com.accolite.au.y2021.mt._6threadpriority;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author sree
 * If you have plenty of free CPU, every thread which can run will run. 
		 	The OS has no reason not to run a low priority thread or process when it has free resources.
			If your system is close to 100% of CPU on every core, 
				the OS has to make a choice as to how much time each thread or process gets on the CPU and it is likely to give favor to higher priority threads over lower priority threads.
 *
 */
public class ThreadPriority {
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		
		// Utility method to create a Thread of type LongRunning
		Thread mango = PriorityRunnable.getThreadInstance("Mango", Thread.MAX_PRIORITY);
		Thread green = PriorityRunnable.getThreadInstance("Green", 2);
		Thread white = PriorityRunnable.getThreadInstance("White", 7);
		Thread blue = PriorityRunnable.getThreadInstance("Blue", Thread.MIN_PRIORITY);
		
		Thread black = PriorityRunnable.getThreadInstance("Balck");
		
		// TODO Sree: !!RPick
		Thread thousand = PriorityRunnable.getThreadInstance("1000", 1000);
		//Thread zero = PriorityRunnable.getThreadInstance("Zero", 0);
		//Thread minus = PriorityRunnable.getThreadInstance("Minus", -1);

		mango.start();
		blue.start();
		
		green.start();
		white.start();
		black.start();
		
		// TODO: Sree: o/p - what really happened? !!RPick
		
		thousand.start();
		//zero.start();
		//minus.start();
		
		// TODO Sree: !!RPick
		// System.out.println(Thread.currentThread().getName() + " -- Priority -- " + Thread.currentThread().getPriority());
		
		//System.out.println(Thread.currentThread().getName() + " -- Completed.");
	}
}
