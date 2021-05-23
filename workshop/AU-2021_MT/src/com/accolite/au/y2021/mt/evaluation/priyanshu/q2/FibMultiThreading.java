package com.accolite.au.y2021.mt.evaluation.priyanshu.q2;

//Review: Sree -- You are creating more threads than excepted number - if the in put is  10 then there should be exactly 10 threads craeted. Also, print the thread name rather than i
public class FibMultiThreading extends Thread {
	private int x;
	public int answer;

	public FibMultiThreading(int x) {
		this.x = x;
	}

	public void run() {
		if (x == 0)
			answer = 0;
		else if (x == 1) {
			answer = 1;
		} else if (x == 2) {
			answer = 1;
		} else {
			try {
				FibMultiThreading f1 = new FibMultiThreading(x - 1);
				FibMultiThreading f2 = new FibMultiThreading(x - 2);
				f1.start();
				f2.start();
				f1.join();
				f2.join();
				answer = f1.answer + f2.answer;
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

	public static void main(String[] args) {
		try {
			int inputNum = 10;
			for (int i = 1; i <= inputNum; i++) {
				FibMultiThreading f = new FibMultiThreading(i);
				f.start();
				f.join();
				System.out.println(i + " => " + f.answer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}