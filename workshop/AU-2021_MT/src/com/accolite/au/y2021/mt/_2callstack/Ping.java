package com.accolite.au.y2021.mt._2callstack;

import com.accolite.au.y2021.mt.common.ThreadUtils;

public class Ping {

	public void ping() {
		System.out.println("PING Starts *******************\n");
		ThreadUtils.printStacks(Thread.currentThread());
		System.out.println("PING Ends *******************\n");
	}
}
