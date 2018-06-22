package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Liam", "Neeson", "Aslan@Testing.com");
			
			// Start transaction
			session.beginTransaction();
			
			// Save the student object
			session.save(student);
			
			// Commit transaction
			session.getTransaction().commit();
			
			
			
			// Retrieve object from database
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student retrievedStudent = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			
			System.out.printf("%b%n", retrievedStudent.equals(student));
			
		}
		finally {
			factory.close();
		}
	}

}
