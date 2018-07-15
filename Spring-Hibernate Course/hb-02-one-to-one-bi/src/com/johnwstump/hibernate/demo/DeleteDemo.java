package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;
import com.johnwstump.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			Instructor instructor = session.get(Instructor.class, 2);
			
			if (instructor != null) {
				
				// Delete the instructor
				// Also deletes the associated details object because of CascadeType.ALL
				session.delete(instructor);
			}
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
