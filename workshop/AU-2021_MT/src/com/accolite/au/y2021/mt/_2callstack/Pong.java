package com.accolite.au.y2021.mt._2callstack;

import com.accolite.au.y2021.mt.common.ThreadUtils;

public class Pong {
	
	public void pong() {
		System.out.println("PONG Starts *******************\n");
		ThreadUtils.printStacks(Thread.currentThread());
		new Ping().ping();
		System.out.println("PONG Ends *******************\n");
	}
}
