package com.accolite.au.y2021.mt.sree.horserace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.accolite.au.y2021.mt.common.ThreadUtils;

/**
 * 
 * @author sree
 *
 */
public class RaceStarterMain {

	public static void main(String[] args) {
		RaceConfig race = new RaceConfig(1 * 1000L, 10L, 100);
		new RaceStarterMain().start(race);
	}

	private void start(RaceConfig race) {
		
		System.out.println(Thread.currentThread().getName() + " -- In start");
		
		ExecutorService tp = Executors.newFixedThreadPool(race.getNoOfHorses() + 1);
		Object lock = new Object();
		CountDownLatch latch = new CountDownLatch(race.getNoOfHorses());
		List<Horse> horses = prepareHorses(lock, race, latch);
		List<Future<RaceStats>> resultsF = new ArrayList<>(); 
		RandomSpeedSetter speedSetter = new RandomSpeedSetter(lock, horses);
		
		horses.forEach(t -> {
			resultsF.add(tp.submit(t));
		});
		tp.submit(speedSetter);
		
		try {
			latch.await();
		} catch (InterruptedException e) {
		}
		
		ThreadUtils.sleepForSeconds(2);
		speedSetter.setRaceDone();
		ThreadUtils.sleepForSeconds(2);
		synchronized (lock) {
			lock.notify();
		}
		
		List<RaceStats> results = prepareRaceResults(resultsF);
		
		System.out.println(Thread.currentThread().getName() + " -- Race result --> \n" + results);
		
		System.out.println(Thread.currentThread().getName() + " -- Going to shut down race cource !!.");
		
		ThreadUtils.sleepForSeconds(5);
		
		tp.shutdown();
	}

	private List<RaceStats> prepareRaceResults(List<Future<RaceStats>> resultsF) {
		List<RaceStats> results = resultsF.stream().map(t -> {
			try {
				return t.get();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}).collect(Collectors.toList());
		results.sort((RaceStats a, RaceStats b) -> a.getTotalTimeInSeconds().compareTo(b.getTotalTimeInSeconds()));
		return results;
	}

	private List<Horse> prepareHorses(Object lock, RaceConfig race, CountDownLatch latch) {
		List<Horse> hs = new ArrayList<>();
		for (int i =0; i < race.getNoOfHorses(); i++) {
			hs.add(new Horse("Horse No: " + (i +1), lock, latch, race));
		}
		return hs;
	}
}
