package com.johnwstump.springdemo.fortuneservice.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.johnwstump.springdemo.fortuneservice.FortuneService;

@Component
public class FileFortuneService implements FortuneService{

	private String[] fortunes;
	
	@PostConstruct
	public void init(){
		File file = new File("fortunes.txt");
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<String> temp = new ArrayList<String>();
			while (bufferedReader.ready()) {
				temp.add(bufferedReader.readLine());
			}
			
			this.fortunes = temp.toArray(new String[temp.size()]);
			bufferedReader.close();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	@Override
	public String getFortune() {
		return fortunes[(int)(Math.random() * fortunes.length)];
	}

}
