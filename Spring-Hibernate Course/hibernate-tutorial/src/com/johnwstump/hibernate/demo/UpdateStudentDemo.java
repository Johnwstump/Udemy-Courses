package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			// Create a student object
			int studentId = 1;
			
			// Retrieve object from database
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student retrievedStudent = session.get(Student.class, studentId);
			retrievedStudent.setFirstName("Andrew");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("UPDATE Student SET email='foo@gmail.com' WHERE id <= 1").executeUpdate();
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
