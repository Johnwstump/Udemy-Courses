package com.johnwstump.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// Create object mapoer
			ObjectMapper mapper = new ObjectMapper();
			
			// Read JSON file and conver to Java POJO
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// Print first and last name
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getAddress());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
	