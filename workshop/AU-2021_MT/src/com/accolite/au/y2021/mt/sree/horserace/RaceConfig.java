package com.accolite.au.y2021.mt.sree.horserace;

/**
 * 
 * @author sree
 *
 */
public class RaceConfig {
	
	public RaceConfig(Long raceTrackLengthInMeters, Long gearShiftIntervalSeconds, int noOfHorces) {
		this.raceTrackLengthInMeters = raceTrackLengthInMeters;
		this.gearShiftIntervalSeconds = gearShiftIntervalSeconds;
		this.noOfHorses = noOfHorces;
	}
	
	public Long getRaceTrackLengthInMeters() {
		return raceTrackLengthInMeters;
	}

	public int getNoOfHorses() {
		return noOfHorses;
	}

	public Long getGearShiftIntervalSeconds() {
		return gearShiftIntervalSeconds;
	}

	private final Long raceTrackLengthInMeters;
	private final Long gearShiftIntervalSeconds;
	private final int noOfHorses;
}
