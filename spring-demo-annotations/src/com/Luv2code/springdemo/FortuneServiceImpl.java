package com.Luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Happy Lucky";
	}

}
