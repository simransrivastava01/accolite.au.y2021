package com.accolite.au.y2021.mt.sree.horserace;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 
 * @author sree
 *
 */
public class RandomSpeedSetter implements Callable<Void> {
	
	public RandomSpeedSetter(Object lock, List<Horse> horses) {
		this.lock = lock;
		this.horses = horses;
	}

	private final Object lock;
	private final List<Horse> horses;
	
	private boolean reaceDone = false;
	
	@Override
	public Void call() throws Exception {
		//System.out.println(Thread.currentThread().getName() + " -- Going to set Random speeds.");
		horses.forEach(h -> {
			if (null == h.getRandomSpeed()) {
				h.setRandomSpeed(generateRandomSpeed());
			}
		});
		takeRest();
		if (!reaceDone) {
			call();
		}
		return null;
	}

	private void takeRest() {
		//System.out.println(Thread.currentThread().getName() + " -- Going to wait.");
		synchronized(lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static double generateRandomSpeed() {
		// mtr/sec
		// 16.7 M/S = 60 KM/H
		// 27.8 M/S = 100 KM/H
		// 11 - 29 m/s;
		
		double tens = getRandomBetween(1, 3);
		double last = getRandomBetween(5, 10);
		double decimals = getRandomBetween(0, 99);
		double temp = tens * 10 + last;
		return temp + (decimals > 9 ? decimals/100 : decimals/10);
	}

	public static int getRandomBetween(int start, int end) {
		int initRandom = new Random().nextInt(end);
		if (initRandom < start) {
			initRandom += start;
		}
		return initRandom;
	}

	public void setRaceDone() {
		this.reaceDone = true;
		System.out.println(Thread.currentThread().getName() + " -- Race done, going to RETURN!!");
	}
}
