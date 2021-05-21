package com.accolite.au.y2021.mt._91advanced;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author sree
 * Students to explore the usecase of the classes.
 */
public class JavaConcurrencyPackage {
	
	// Since 6
	// Important classes are as follows.
	
	ExecutorService es;
	Callable<String> c;
	Future<String> f;
	
	BlockingQueue<String> bqA = new ArrayBlockingQueue<>(10);
	BlockingQueue<String> bqL = new LinkedBlockingDeque<>();
	
	CopyOnWriteArrayList<String> coal;
	ConcurrentHashMap<String, Object> chm;
	
	CyclicBarrier barrier;
	CountDownLatch latch;
	
	AtomicInteger ai;
}
