package com.johnwstump.springdemo.fortuneservice.impl;

import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class DatabaseFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "This is a database fortune";
	}

}
