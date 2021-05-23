package assignment;
import java.util.*;

class HorseRace extends Thread {
	Horse horse;
	Result r;
	static int distance = 1000;
	static int n;
	
	HorseRace(Horse h, Result r) {
		this.horse = h;
		this.r = r;

	}

	public void run() {
		do 
		{
			synchronized (this)
			{
				Thread race = Thread.currentThread();
				if (horse.distanceCovered >= distance) {
					r.list.add(horse);
					r.count++;
					break;
				}
				SpeedClass ss = new SpeedClass(horse);
				ss.start();
				try 
				{
					ss.join();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
				Check s = new Check(horse, race.getName());
				s.start();

			}
		} 
		
		while (true);
		if (r.count == n)
		{
			System.out.println("Horse Race is Finished ");
			System.out.println("============================================================");
			for (int i = 1; i <= r.list.size(); i++) 
			{
				Horse horse = r.list.get(i - 1);
				if (i == 1)
				{
			System.out.println(horse.name +" scored position " + i );
			System.out.println("Top speed : " + horse.topSpeed + "m/s" );
			System.out.println( "Lowest speed : "+ horse.lowSpeed + "m/s");
			System.out.println("Average Speed : " + horse.averageSpeed + "m/s" );
			System.out.println("All the speed of horse are : "+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
				}
				else {
				
					System.out.println(horse.name +" scored position " + i );
					System.out.println("Top speed : " + horse.topSpeed + "m/s" );
					System.out.println( "Lowest speed : "+ horse.lowSpeed + "m/s");
					System.out.println("Average Speed : " + horse.averageSpeed + "m/s" );
					System.out.println("All the speed of horse are : "+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
						
				}
				System.out.println("=============================================================================");
			}
		}
	}

	public static void main(String[] args) {
		Result r = new Result();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many horses for race: ");
		 n=sc.nextInt();
		
		for (int i = 0; i < n; i++)
		{ 
			HorseRace h = new HorseRace(new Horse("Horse " + i), r);
			h.start();

		}

	}
}




class SpeedClass extends Thread {
	Horse horse;

	public SpeedClass(Horse horse) {
		this.horse = horse;
	}

	public void run() {
		horse.speed = ((int) (((Math.random() * 10) + 40) + (Math.random() * 10)));
	}
}





class Check extends Thread {
	Horse horse;
	String Tname;

	public Check(Horse h, String Tname) {
		horse = h;
		this.Tname = Tname;

	}

	public void run() {
		
		synchronized (this) {
			horse.speeds += horse.speed;
			horse.totallSpeedChanges += 1;
			horse.speedHistory += horse.speed + "m/s   ";
			horse.distanceCovered += horse.speed * 10;
			horse.averageSpeed = horse.speeds / horse.totallSpeedChanges;

			if (horse.topSpeed < horse.speed)
				horse.topSpeed = horse.speed;
			
			if (horse.lowSpeed > horse.speed)
				horse.lowSpeed = horse.speed;
		}
	}
}






class Result {
	ArrayList<Horse> list;
	int count = 0;

	Result() {
		list = new ArrayList<>();
	}
}






class Horse {
	int speed = 0,speeds=0,distanceCovered=0,totallSpeedChanges=0;
	float averageSpeed;
	int topSpeed = Integer.MIN_VALUE;
	int lowSpeed = Integer.MAX_VALUE;
	String speedHistory = "";
	String name;

	public Horse(String name) {
		this.name = name;

	}
}
