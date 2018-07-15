package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Course;
import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Course course1 = new Course("Intro to Programming");
			Course course2 = new Course("Intro to Pottery");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			
			// Save the objects
			session.save(course1);
			session.save(course2);
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
