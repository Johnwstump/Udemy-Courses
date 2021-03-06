package com.johnwstump.springdemo.coach.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	@PostConstruct
	public void init() {
		System.out.println("This is the init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("This is the destroy method");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice bowling for 1 hour.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Autowired
	@Qualifier("fileFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
