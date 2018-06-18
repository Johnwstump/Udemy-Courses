package com.johnwstump.springdemo.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.fortuneservice.FortuneService;

public class SwimCoach implements Coach{

	@Value("${coach.email}")
	private String email;
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Swim 100 meters as a warm up.";
	}

	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	public String getEmail() {
		return this.email;
	}
}
