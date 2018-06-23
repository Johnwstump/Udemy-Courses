package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;
import com.johnwstump.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			// Create objects
			
			Instructor instructor = new Instructor("John", "Stump", "johnwstump@outlook.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://fake.com/youtube", "Reading");
			
			/*
			Instructor instructor = new Instructor("Bill", "Magoo", "billyMagoo@outlook.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://Test.com/youtube", "Writing");
			*/
			
			// Associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// Start transaction
			session.beginTransaction();

			// Save the objects
			session.save(instructor);
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
