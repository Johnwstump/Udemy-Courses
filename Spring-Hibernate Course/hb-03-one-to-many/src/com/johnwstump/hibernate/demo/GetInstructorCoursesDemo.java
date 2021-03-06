package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Course;
import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			// Start transaction
			session.beginTransaction();

			// Retrieve instructor
			Instructor instructor = session.get(Instructor.class, 1);
			
			System.out.println(instructor);
			System.out.println(instructor.getCourses());
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
