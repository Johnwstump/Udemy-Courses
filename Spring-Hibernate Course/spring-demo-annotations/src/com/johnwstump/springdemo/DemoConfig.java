package com.johnwstump.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.johnwstump.springdemo.coach.Coach;
import com.johnwstump.springdemo.coach.impl.SwimCoach;
import com.johnwstump.springdemo.fortuneservice.FortuneService;
import com.johnwstump.springdemo.fortuneservice.impl.HappyFortuneService;
import com.johnwstump.springdemo.fortuneservice.impl.SadFortuneService;

@Configuration
@ComponentScan("com.johnwstump.springdemo")
@PropertySource("classpath:coach.properties")
public class DemoConfig {
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
