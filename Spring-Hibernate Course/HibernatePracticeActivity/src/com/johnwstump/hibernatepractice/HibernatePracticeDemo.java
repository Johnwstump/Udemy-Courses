package com.johnwstump.hibernatepractice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.johnwstump.hibernatepractice.entity.Employee;

public class HibernatePracticeDemo {

	private static SessionFactory factory;
	public static void main(String[] args) {
		factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// Call CRUD functions to test
		Employee test1 = new Employee("Bill", "Test", "techsoft");
		Employee test2 = new Employee("Sarah", "Beta", "techworks");
		Employee test3 = new Employee("Amanda", "Blumenthal", "Pear");
		Employee test4 = new Employee("Dave", "Wilder", "Macrotough");
		Employee test5 = new Employee("Nial", "Tannington", "Pear");
		
		System.out.println("Testing add");
		addEmployee(test1);
		addEmployee(test2);
		addEmployee(test3);
		addEmployee(test4);
		addEmployee(test5);
		
		System.out.println("Testing retrieval");
		Employee retrieved3 = retrieveEmployee(test3.getEmployeeId());
		System.out.printf("Retrieved object: %s%n", retrieved3.toString());
		
		System.out.println("Testing retrieval by company");
		List<Employee> pearEmployees = retrieveEmployeesByCompany("Pear");
		
		for (Employee e : pearEmployees) {
			System.out.println(e.toString());
		}
		
		System.out.println("Testing delete");
		deleteEmployee(test1.getEmployeeId());
		deleteEmployee(test2.getEmployeeId());
		deleteEmployee(test3.getEmployeeId());
		deleteEmployee(test4.getEmployeeId());
		deleteEmployee(test5.getEmployeeId());
		
		factory.close();
	}
	
	private static boolean addEmployee(Employee e) {
		try {
			Session s = factory.getCurrentSession();
			s.beginTransaction();
			s.save(e);
			s.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	private static Employee retrieveEmployee(int employeeId) {
		Employee employee = null;
		try {
			Session s = factory.getCurrentSession();
			s.beginTransaction();
			employee = s.get(Employee.class, employeeId);
			s.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return employee;
	}
	
	private static List<Employee> retrieveEmployeesByCompany(String company) {
		List<Employee> employees = null;
		try {
			Session s = factory.getCurrentSession();
			s.beginTransaction();
			employees = s.createQuery("FROM Employee e WHERE e.company = '" + company +"'").getResultList();
			s.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return employees;
	}
	
	private static boolean deleteEmployee(int employeeId) {
		try {
			Session s = factory.getCurrentSession();
			s.beginTransaction();
			Employee e = s.get(Employee.class, employeeId);
			s.delete(e);
			s.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
