package com.accolite.au.y2021.mt.evaluation.paras.q6;
import java.util.*;

class HorseRace extends Thread {
	Horse horse;//global reference for horse object
	Result rs;//global reference for Result class for storing horse object in list and for incrementing counter
    int gap;
    static int num;
	 static int distance;//i have taken distance to be covered by horses as 1000 , we can also ask user to provide this 
	
	HorseRace(Horse h,Result rs,int gap)
	{
		this.horse=h;
		this.rs=rs;
		this.gap=gap;
		
	}
	
	public void run()
	{  
	    do {//do while block is used so that a single horse thread can keep on running till the finish line 
	       synchronized(this)//synchronized so that only one thread can manipulate it at a time
	      {   Thread race  =Thread.currentThread();
	    	   if(horse.distanceCovered>=distance)
	    	    {rs.list.add(horse);//if horse has reached the finish line then insert the final updated horse object in list
	    	     rs.count++;// increase the counter so that we can print our result when counters value becomes equal to number of horse 
	    	     break;//loops get terminated because our horse has finished the race so no need to run more 
	    		 }
	    		 SpeedSetter ss=new SpeedSetter(horse);//calling  speedSetter Thread for new Random speed value 
	    		 ss.start();
	    		 try{ss.join();}catch(Exception e) {e.printStackTrace();}// so that no further work is done before updating speed value
	    	 	 Statics s=new Statics(horse,race.getName(),gap);//calling thread so that we can update the horse object acc to the speed we got above
	    	        s.start();
	    	    	    	   
	  	      }
	    }while(true);//this is true until horse.distanceCovered<distance 
	    if(rs.count==num)//if this value is equal to number of horses that means we got our results and 
	    {
	    	 System.out.println("Race Finish...............");
			  for(int i=1;i<=rs.list.size();i++) 
			  { Horse horse= rs.list.get(i-1);
				  if(i==1)System.out.println( horse.name+"->"+"is at position "+i+"\n"+"Top speed during race"+"->"+horse.topSpeed+"m/s"
			   +"\n"+"Lowest Speed During Race"+"->"+horse.lowSpeed+"m/s"+"\n"+"Average Speed was"+"->"+horse.averageSpeed+"m/s"+"\n"+
					  "Speed Transition History"+"->"+horse.speedHistory.substring(0,horse.speedHistory.length()-2)+"\n"+"time taken to complete the race ->"+horse.timeTaken+"s"+"\n");
			  //getting horse objects from list and printing the result
			  else
			  {
				  System.out.println( horse.name+"->"+"is at position "+i+"\n"+"Top speed during race"+"->"+horse.topSpeed+"m/s"
				 +"\n"+"Lowest Speed During Race"+"->"+horse.lowSpeed+"m/s"+"\n"+"Average Speed was"+"->"+horse.averageSpeed+"m/s"+"\n"+
		      "Speed Transition History"+"->"+horse.speedHistory.substring(0,horse.speedHistory.length()-2)+"\n"+"time taken to complete the race ->"+horse.timeTaken+"s"+"\n");
			  }
			  System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			  }		 
	    }   	
	}
	public static void main(String[] args)
	{	java.util.Scanner scn=new Scanner(System.in);
        System.out.println("input Number Of Horses:");
        num=scn.nextInt();
        System.out.println("input Speed Change Gap:");
        int gap=scn.nextInt();
        System.out.println("input Distance To Be Covered in meters ex 1000,5000 etc:");
          distance=scn.nextInt();
        
    
		  Result rs=new Result();//result class object to pass it in thread
		  for (int i = 0; i <num; i++) { // i have taken no of horses as 5 we can also take them through user input
		      	HorseRace h1=new HorseRace(new Horse("horse"+i),rs,gap);// thread objects
		        h1.start();//starting thread
		       
		        }
		  scn.close();
		  
		}
}


