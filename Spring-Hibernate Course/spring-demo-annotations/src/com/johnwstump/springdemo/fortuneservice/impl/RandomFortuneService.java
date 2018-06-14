package com.johnwstump.springdemo.fortuneservice.impl;

import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class RandomFortuneService implements FortuneService{
	private final String[] FORTUNES = {"Today will be a good day", "Today will be an okay day", "Don't make any long term plans"};

	@Override
	public String getFortune() {
		return FORTUNES[(int)(Math.random() * FORTUNES.length)];
	}
}
