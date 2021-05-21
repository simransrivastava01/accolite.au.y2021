package com.accolite.au.y2021.mt.evaluation.adishi.q4;

import java.util.Scanner;

public class Factorial implements Runnable {
	// logic to find factorial of a number
	public int factorials(int i) {
		int j, f = 1;
		for (j = 1; j <= i; j++)
			f = f * j;
		return f;
	}

	@Override
	public void run() {
	}

	// main method
	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter the number of factorials you want to print ::");
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				Thread td = new Thread(new Factorial());
				td.start();
				Factorial factorial = new Factorial();
				System.out.println("Factorial of " + i + " = " + factorial.factorials(i) + "  " + td.getName());
			}
		}
	}
}