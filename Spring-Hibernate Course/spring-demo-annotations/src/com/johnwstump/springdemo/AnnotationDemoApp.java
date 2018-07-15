package com.johnwstump.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnwstump.springdemo.coach.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// Load Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean
		Coach currentCoach = context.getBean("currentCoach", Coach.class);
		System.out.println("\n-- Testing Annotation--");
		System.out.println(currentCoach.getDailyWorkout());
		
		// Test Autowired field injection from property file
		System.out.println(currentCoach.getEmail());
		
		// Test Autowiring with Constructor Injection
		System.out.println("\n-- Testing Constructor Injection with Autowiring--");
		System.out.println(currentCoach.getDailyFortune());
		
		// Test Autowiring with Setter Injection
		currentCoach = context.getBean("cricketCoach", Coach.class);
		System.out.println("\n-- Testing Setter Injection with Autowiring--");
		System.out.println(currentCoach.getDailyFortune());
		
		// Test Autowiring with field Injection
		currentCoach = context.getBean("baseballCoach", Coach.class);
		System.out.println("\n-- Testing Field Injection with Autowiring--");
		System.out.println(currentCoach.getDailyFortune());
		
		// Test default bean-id
		System.out.println("\n-- Testing Annotations with default bean-id--");
		currentCoach = context.getBean("footballCoach", Coach.class);
		System.out.println(currentCoach.getDailyWorkout());
		System.out.println(currentCoach.getDailyFortune());
		
		// Tests switching to prototype scope with annotations
		Coach secondCoach = context.getBean("footballCoach", Coach.class);
		System.out.printf("These beans use the prototype scope: %b%n", currentCoach != secondCoach);
		
		// Close context
		context.close();
	}
}
