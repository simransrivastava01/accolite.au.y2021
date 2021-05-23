package com.accolite.au.y2021.mt.evaluation.paras.q6;

/*this is Horse class containing properties of horse*/
class Horse{
	int speed=0;//speed at that particular time assigned randomly
	int speeds=0;//sum of all the previous speeds in order to get average speed
	int distanceCovered=0;//distance covered by horse
	float averageSpeed;//average speed to be counted by (speeds/totallSpeedChanges)
	int timeTaken=0;//time taken to complete the race
	int totallSpeedChanges=0;//no of times speed changed , so that we can get averageSpeed
	int topSpeed=Integer.MIN_VALUE;//top speed of a horse during race
	int lowSpeed=Integer.MAX_VALUE;//lowest speed of a horse during race
	String speedHistory="";// all the speeds during the race
	String name;//name of the horse
	public Horse(String name)
	{
	  this.name=name;
	  
	}	
}