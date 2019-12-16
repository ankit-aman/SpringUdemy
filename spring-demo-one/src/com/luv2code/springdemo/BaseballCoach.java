package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	public FortuneService service;
	
	 public BaseballCoach(FortuneService service) {
		this.service=service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return service.getFortune();
	}

}







