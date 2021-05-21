package com.accolite.au.y2021.mt.sree.horserace;

/**
 * 
 * @author sree
 *
 */
public class Lap {
	private final int number;
	private final double speed;
	private final double time;
	private final double distanceCovered;
	
	public Lap(int number, double speed, double time, double distanceCovered) {
		this.number = number;
		this.speed = speed;
		this.time = time;
		this.distanceCovered = distanceCovered;
	}

	public int getNumber() {
		return number;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDistanceCovered() {
		return distanceCovered;
	}

	public double getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Lap [number=" + number + ", speed=" + speed + ", time=" + time + ", distanceCovered=" + distanceCovered + "]";
	}
}
