package com.johnwstump.springdemo.coach.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component("currentCoach")
public class TennisCoach implements Coach{

	private FortuneService fortuneService;
	@Value("${coach.email}")
	private String email;
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	
	public String getEmail() {
		return this.email;
	}

}
