package com.accolite.au.y2021.mt.evaluation.score;

import java.util.Arrays;
import java.util.List;

public enum Score {
	
	Mohit(50, "PENDING_FINAL"),
	Vikram(65, "PENDING_FINAL"),
	Adishi(40, "PENDING_FINAL"),
	Paras(60, "PENDING_FINAL");
	
	private Score(double score, String status) {
		this.score = score;
		this.status = status;
	}
	
	final Double score;
	final String status;
	
	public static void main(String[] args) {
		System.out.println("***** Report *****");
		List<Score> sl = Arrays.asList(Score.values());
		sl.sort((a, b) -> b.score.compareTo(a.score));
		sl.forEach(a -> System.err.println(1 + sl.indexOf(a) + ".\t" + a.name() + "\t\t====> " + a.score + " -- " + a.status));
	}
}
