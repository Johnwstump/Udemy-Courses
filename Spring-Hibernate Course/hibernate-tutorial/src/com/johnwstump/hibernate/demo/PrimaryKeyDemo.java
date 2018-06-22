package com.johnwstump.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			// Create student objects
			Student student1 = new Student("John", "Doe", "JohnDoe@Testing.com");
			Student student2 = new Student("Louis", "Armstrong", "LArmstrong@Testing.com");
			Student student3 = new Student("Hannah", "Jane", "HJ@Testing.com");
			
			// Start transaction
			session.beginTransaction();
			
			// Save student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
