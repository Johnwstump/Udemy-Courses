package com.johnwstump.springdemo.fortuneservice.impl;

import com.johnwstump.springdemo.fortuneservice.FortuneService;

public class SadFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "Today is a sad day";
	}
	

}
