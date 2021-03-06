package com.johnwstump.springdemo.coach.impl;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.dietservice.DietService;
import com.johnwstump.springdemo.motivationservice.MotivationService;

public class FootballCoach implements Coach{

	private MotivationService motivationService;
	private DietService dietService;
	
	public FootballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run drills for one hour.";
	}

	@Override
	public String getDailyMotivation() {
		return this.motivationService.getMotivationalMessage();
	}

	@Override
	public String getDailyDiet() {
		if (dietService == null) {
			return "No diet information available.";
		}
		
		return dietService.getDailyDiet();
	}
	
	public void setDietService(DietService dietService) {
		this.dietService = dietService;
	}
	
	public void init() {
		System.out.println("This is the init function");
	}
	
	public void destroy() {
		System.out.println("This is the destroy function");
	}

	
}
