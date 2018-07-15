package com.johnwstump.springdemo.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class BaseballCoach implements Coach{

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 1 hour in the batting cages";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
