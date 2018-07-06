package com.johnwstump.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SpringDemoRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world!";
	}
}
