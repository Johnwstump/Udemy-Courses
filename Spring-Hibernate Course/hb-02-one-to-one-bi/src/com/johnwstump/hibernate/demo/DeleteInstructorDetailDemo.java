package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;
import com.johnwstump.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			int id = 3;
			
			// Get instructor via primary key
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("Detail: " + detail.toString());
			System.out.println("Instructor: " + detail.getInstructor().toString());
			
			// Now delete the instructor demo
			session.delete(detail);
			
			// Commit transaction
			session.getTransaction().commit();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
