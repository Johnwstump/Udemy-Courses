package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;
import com.johnwstump.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			// Start transaction
			session.beginTransaction();
			
			// Get instructor via primary key
			InstructorDetail detail = session.get(InstructorDetail.class, 3);
			
			System.out.println("Detail: " + detail.toString());
			System.out.println("Instructor: " + detail.getInstructor().toString());
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
