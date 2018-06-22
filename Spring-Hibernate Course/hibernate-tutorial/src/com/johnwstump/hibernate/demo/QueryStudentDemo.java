package com.johnwstump.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			session.beginTransaction();
			// Test select * query
			List<Student> students = session.createQuery("from Student").getResultList();
			printStudentList(students);
			
			// Test conditional query
			List<Student> doeStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			printStudentList(doeStudents);
			
			// Test multiple conditions
			students = session.createQuery("from Student s where s.lastName='doe' OR s.firstName='louis'").getResultList();
			printStudentList(students);
			
			students = session.createQuery("from Student s where s.email LIKE '%Testing.com'").getResultList();
			printStudentList(students);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	private static void printStudentList(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
