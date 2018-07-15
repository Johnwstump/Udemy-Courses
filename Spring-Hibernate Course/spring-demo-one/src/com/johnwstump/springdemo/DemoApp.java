package com.johnwstump.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnwstump.springdemo.coach.Coach;

public class DemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach currentCoach = context.getBean("currentCoach", Coach.class);
		System.out.printf("Your daily workout: %s %n", currentCoach.getDailyWorkout());
		
		// Demonstrates constructor injection
		System.out.printf("Your daily motivation: %s %n", currentCoach.getDailyMotivation());
		
		// Demonstrates setter injection
		System.out.printf("Your daily diet: %s %n", currentCoach.getDailyDiet());
		
		// Demonstrates bean prototype bean scope
		Coach comparisonCoach = context.getBean("currentCoach", Coach.class);
		System.out.printf("Coaches are different: %b%n", currentCoach != comparisonCoach);
		
		// Demonstrates init and destroy function hookups
		Coach secondCoach = context.getBean("secondCoach", Coach.class);
		
		context.close();
	}
}
