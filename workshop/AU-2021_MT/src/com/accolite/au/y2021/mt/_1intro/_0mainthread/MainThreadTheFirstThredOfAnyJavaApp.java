package com.accolite.au.y2021.mt._1intro._0mainthread;

/**
 * 
 * @author sree
 *
 */
public class MainThreadTheFirstThredOfAnyJavaApp {
	
	public static void main(String[] args) {
		
		System.out.println("**** S T A R T ****");
		
		// Get the current thread executing this part of the code.
		Thread currentThread = Thread.currentThread();
		
		// We can assign thread a name, if we are not, then java will do that for you.
		String currentThreadName = currentThread.getName();
		System.out.println("currentThreadName - " + currentThreadName);
		
		System.out.println("thread state - " + currentThread.getState());
		
		// Set name
		currentThread.setName("Bhaskar");
		currentThreadName = currentThread.getName();
		System.out.println("currentThreadName - " + currentThreadName);
		
		System.out.println("**** E N D ****");
	}
}
