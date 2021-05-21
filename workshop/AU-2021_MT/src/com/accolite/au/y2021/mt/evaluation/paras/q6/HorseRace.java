package com.accolite.au.y2021.mt.evaluation.paras.q6;

import java.util.*;

/*Result class is to store result of horses*/
class Result {
	ArrayList<Horse> list;// this will have horse objects
	int count = 0;// this is counter for do while loop condition

	Result() {
		list = new ArrayList<>();

	}
}

/* this is Horse class containing properties of horse */
class Horse {
	int speed = 0;// speed at that particular time assigned randomly
	int speeds = 0;// sum of all the previous speeds in order to get average speed
	int distanceCovered = 0;// distance covered by horse
	float averageSpeed;// average speed to be counted by (speeds/totallSpeedChanges)
	int totallSpeedChanges = 0;// no of times speed changed , so that we can get averageSpeed
	int topSpeed = Integer.MIN_VALUE;// top speed of a horse during race
	int lowSpeed = Integer.MAX_VALUE;// lowest speed of a horse during race
	String speedHistory = "";// all the speeds during the race
	String name;// name of the horse

	public Horse(String name) {
		this.name = name;

	}
}

/*
 * Statics Thread used for updating horse object every time horse gets a new
 * speed
 */
class Statics extends Thread {
	Horse horse;// global reference for horse object
	String Tname;

	public Statics(Horse h, String Tname) {
		horse = h;
		this.Tname = Tname;

	}

	public void run() {
		/*
		 * synchronized block so that only one thread can manipulate them at a single
		 * time
		 */
		synchronized (this) {
			horse.speeds += horse.speed;// adding speed value in previous speeds
			horse.totallSpeedChanges += 1;// increment in total speed changes by horse
			horse.speedHistory += horse.speed + "m/s->";// concatenating current speed in previous history speeds string
			horse.distanceCovered += horse.speed * 10;// DISTANCE COVERED IS CALCULATED BY SPEED VALUE MULTIPLY BY 10
														// example: IF SPEED =20 THEN 200 METERS
			horse.averageSpeed = horse.speeds / horse.totallSpeedChanges;// calculating average speed

			if (horse.topSpeed < horse.speed)
				horse.topSpeed = horse.speed;// top speed updating
			if (horse.lowSpeed > horse.speed)
				horse.lowSpeed = horse.speed;// low speed updating
		}
	}
}

/*
 * Speed setter thread which gives us a random speed value between 40 to 60 in
 * meter per second
 */
class SpeedSetter extends Thread {
	Horse h;// global reference for horse object

	public SpeedSetter(Horse h) {
		this.h = h;
	}

	public void run() {
		h.speed = ((int) (((Math.random() * 10) + 40) + (Math.random() * 10)));// this is giving us random value between
																				// 40 - 60 ie speed in m/s
	}
}

class HorseRace extends Thread {
	Horse horse;// global reference for horse object
	Result rs;// global reference for Result class for storing horse object in list and for
				// incrementing counter

	static int distance = 1000;// i have taken distance to be covered by horses as 1000 , we can also ask user
								// to provide this

	HorseRace(Horse h, Result rs) {
		this.horse = h;
		this.rs = rs;

	}

	public void run() {
		do {// do while block is used so that a single horse thread can keep on running till
			// the finish line
			synchronized (this)// synchronized so that only one thread can manipulate it at a time
			{
				Thread race = Thread.currentThread();
				if (horse.distanceCovered >= distance) {
					rs.list.add(horse);// if horse has reached the finish line then insert the final updated horse
										// object in list
					rs.count++;// increase the counter so that we can print our result when counters value
								// becomes equal to number of horse
					break;// loops get terminated because our horse has finished the race so no need to
							// run more
				}
				SpeedSetter ss = new SpeedSetter(horse);// calling speedSetter Thread for new Random speed value
				ss.start();
				try {
					ss.join();
				} catch (Exception e) {
					e.printStackTrace();
				} // so that no further work is done before updating speed value
				Statics s = new Statics(horse, race.getName());// calling thread so that we can update the horse object
																// acc to the speed we got above
				s.start();

			}
		} while (true);// this is true until horse.distanceCovered<distance
		if (rs.count == 5)// if this value is equal to number of horses that means we got our results and
		{
			System.out.println("Race Finish...............");
			for (int i = 1; i <= rs.list.size(); i++) {
				Horse horse = rs.list.get(i - 1);
				if (i == 1)
					System.out.println(horse.name + "->" + "is at position " + i + "\n" + "Top speed during race" + "->"
							+ horse.topSpeed + "m/s" + "\n" + "Lowest Speed During Race" + "->" + horse.lowSpeed + "m/s"
							+ "\n" + "Average Speed was" + "->" + horse.averageSpeed + "m/s" + "\n"
							+ "Speed Transition History" + "->"
							+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
				// getting horse objects from list and printing the result
				else {
					System.out.println(horse.name + "->" + "is at position " + i + "\n" + "Top speed during race" + "->"
							+ horse.topSpeed + "m/s" + "\n" + "Lowest Speed During Race" + "->" + horse.lowSpeed + "m/s"
							+ "\n" + "Average Speed was" + "->" + horse.averageSpeed + "m/s" + "\n"
							+ "Speed Transition History" + "->"
							+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
				}
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
		}
	}

	public static void main(String[] args) {
		Result rs = new Result();// result class object to pass it in thread
		for (int i = 0; i < 5; i++) { // i have taken no of horses as 5 we can also take them through user input
			HorseRace h1 = new HorseRace(new Horse("horse" + i), rs);// thread objects
			h1.start();// starting thread

		}

	}
}
