package com.accolite.au.y2021.mt._2callstack;

import com.accolite.au.y2021.mt.common.ThreadUtils;

public class ThreadCallStack {
	
	public static void main(String[] args) {
		System.out.println("main starts******\n");
		
		new Pong().pong();
		
		ThreadUtils.printStacks(Thread.currentThread());

		System.out.println("main ends******\n");
	}
}
