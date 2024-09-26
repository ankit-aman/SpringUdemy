package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fortuneServiceImpl")
	private FortuneService fortuneService;
	
	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService=fortuneService; }
	 */
	
	/*
	 * public TennisCoach() { // TODO Auto-generated constructor stub }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice";
	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
