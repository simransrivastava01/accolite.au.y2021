package com.accolite.au.y2021.mt.evaluation.paras.q6;
/*Statics Thread used for updating horse object every time horse gets a new speed*/
class Statics extends Thread{
	 Horse horse;// global reference for horse object
	 String Tname;
	 int gap;
	 public Statics(Horse h,String Tname,int gap)
	 { horse=h;
	   this.Tname=Tname;
	   this.gap=gap;
		 
	 }
	 public void run()
	 {   
	      /*synchronized block so that only one thread can manipulate them at a single time*/
	      synchronized(this){horse.speeds+=horse.speed;//adding speed value in previous speeds
	      horse.totallSpeedChanges+=1;//increment in total speed changes by horse
	      horse.speedHistory+=horse.speed+"m/s->";//concatenating current speed in previous history speeds string
	      horse.distanceCovered+=horse.speed*gap;//DISTANCE COVERED IS CALCULATED BY SPEED VALUE MULTIPLY BY 10 example: IF SPEED =20 THEN 200 METERS
	      horse.timeTaken+=1;
	      horse.averageSpeed=horse.speeds/horse.totallSpeedChanges;//calculating average speed
	     
	      if(horse.topSpeed<horse.speed)
	         horse.topSpeed=horse.speed;//top speed updating
	      if(horse.lowSpeed>horse.speed)
		     horse.lowSpeed=horse.speed;// low speed updating
	   }
	 }
}