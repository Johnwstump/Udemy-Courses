package com.johnwstump.springdemo.fortuneservice.impl;

import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today will be a good day.";
	}

}
