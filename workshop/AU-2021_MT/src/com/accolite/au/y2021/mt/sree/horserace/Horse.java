package com.accolite.au.y2021.mt.sree.horserace;

import static com.accolite.au.y2021.mt.common.ThreadUtils.sleepForSeconds;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author sree
 *
 */
public class Horse implements Callable<RaceStats> {

	private final String name;
	private final Object lock;
	private final RaceConfig raceConfig;
	private final CountDownLatch latch;
	private final RaceStats myStats;
	
	private Double randomSpeed = null;
	
	public Horse(String name, Object lock, CountDownLatch latch, RaceConfig raceConfig) {
		this.name = name;
		this.lock = lock;
		this.latch = latch;
		this.raceConfig = raceConfig;
		myStats = new RaceStats(name);
	}

	@Override
	public RaceStats call() throws Exception {
		
		while(true) {
			if (null == randomSpeed) {
				//System.out.println(Thread.currentThread().getName() + " -- " + name + " -- Wating for randomSpeed to set.");
				sleepForSeconds(1);
				continue;
			}
			
			doRunRace();
			
			if (rsceCompleted()) {
				System.err.println(Thread.currentThread().getName() + " -- " + name + " -- Race COMPLETED myStats - " + myStats);
				break;
			}
		}
		
		latch.countDown();
		return myStats;
	}

	private void doRunRace() {
		//System.out.println(Thread.currentThread().getName() + " -- " + name + " -- Running, Speed: " + randomSpeed);
		double distanceInThisLap = getRandomSpeed() * raceConfig.getGearShiftIntervalSeconds();
		Lap lapInfo = setStats(distanceInThisLap, getRandomSpeed());
		System.out.println(Thread.currentThread().getName() + " -- " + name + " -- Lap done, lapInfo: " + lapInfo);
		
		this.setRandomSpeed(null);
		synchronized (lock) {
			lock.notify();
		}
	}

	private Lap setStats(double distanceInThisLap, Double randomSpeed) {
		int lapNo = myStats.getLaps().size() + 1;
		double distanceCovered = myStats.getTotalDistanceInMeters() + distanceInThisLap;
		double time = raceConfig.getGearShiftIntervalSeconds();

		if (distanceCovered > raceConfig.getRaceTrackLengthInMeters()) {
			double diff = distanceCovered - raceConfig.getRaceTrackLengthInMeters();
			double distCanBeCoveredInOneSec = distanceInThisLap/raceConfig.getGearShiftIntervalSeconds();
			double deltaTime = diff/distCanBeCoveredInOneSec;
			time = time - deltaTime;
			distanceCovered = raceConfig.getRaceTrackLengthInMeters();
			distanceInThisLap = distanceInThisLap - diff;
		}
		
		Lap aLap = new Lap(lapNo, randomSpeed, time, distanceInThisLap);
		myStats.oneMoreLap(aLap);
		return aLap;
	}

	private boolean rsceCompleted() {
		return myStats.getTotalDistanceInMeters() >= raceConfig.getRaceTrackLengthInMeters();
	}

	public RaceStats getMyStats() {
		return myStats;
	}

	public Double getRandomSpeed() {
		return randomSpeed;
	}

	public void setRandomSpeed(Double randomSpeed) {
		this.randomSpeed = randomSpeed;
	}

	public String getName() {
		return name;
	}

	public Object getLock() {
		return lock;
	}

	public RaceConfig getRaceConfig() {
		return raceConfig;
	}
}
