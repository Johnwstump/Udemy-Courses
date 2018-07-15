package com.johnwstump.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernate.demo.entity.Course;
import com.johnwstump.hibernate.demo.entity.Instructor;
import com.johnwstump.hibernate.demo.entity.InstructorDetail;
import com.johnwstump.hibernate.demo.entity.Review;
import com.johnwstump.hibernate.demo.entity.Student;

public class CreateCourseandStudentsDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			// Start transaction
			session.beginTransaction();

			
			Course course = new Course("History of dance");
			
			Student student1 = new Student("Dave", "Thompson", "DT@gmail.com");
			Student student2 = new Student("Mary", "Lewis", "Marylewis@gmail.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			session.save(course);
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
