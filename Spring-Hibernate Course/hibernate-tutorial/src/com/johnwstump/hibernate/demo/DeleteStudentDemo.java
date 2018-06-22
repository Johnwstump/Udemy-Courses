package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {				
			int studentId = 1;
			
			// Start transaction
			session.beginTransaction();
			
			/**
			// Delete the student
			Student student = session.get(Student.class, studentId);
			session.delete(student);
			**/
			
			
			studentId = 2;
			
			// Delete student with query
			session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
