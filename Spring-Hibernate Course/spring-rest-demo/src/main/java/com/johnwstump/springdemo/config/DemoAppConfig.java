package com.johnwstump.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.johnwstump.springdemo")
@EnableWebMvc
public class DemoAppConfig {

}
