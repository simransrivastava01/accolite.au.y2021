package com.accolite.au.y2021.mt.sree.horserace;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sree
 *
 */
public class RaceStats {
	
	public RaceStats(String horseId) {
		this.horseId = horseId;
	}
	
	private final List<Lap> laps = new ArrayList<>();
	private final String horseId;
	
	private double totalTimeInSeconds = 0d;
	private double totalDistanceInMeters = 0d;
	
	public void oneMoreLap(Lap aLap) {
		totalTimeInSeconds += aLap.getTime();
		totalDistanceInMeters += aLap.getDistanceCovered();
		laps.add(aLap);
	}

	public List<Lap> getLaps() {
		return laps;
	}

	public String getHorseId() {
		return horseId;
	}

	public Double getTotalTimeInSeconds() {
		return totalTimeInSeconds;
	}

	public void setTotalTimeInSeconds(double totalTimeInSeconds) {
		this.totalTimeInSeconds = totalTimeInSeconds;
	}

	public double getTotalDistanceInMeters() {
		return totalDistanceInMeters;
	}

	public void setTotalDistanceInSeconds(double totalDistanceInSeconds) {
		this.totalDistanceInMeters = totalDistanceInSeconds;
	}

	@Override
	public String toString() {
		return "RaceStats [horseId=" + horseId + ", totalTimeInSeconds=" + totalTimeInSeconds + ", totalDistanceInMeters=" + totalDistanceInMeters + "]\n";
	}
	
	
}
