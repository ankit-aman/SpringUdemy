package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	public TrackCoach() {
		System.out.println("in Track coach construct");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}










