package com.java.training.hibernate;

import org.hibernate.Session;

import com.java.training.hibernate.entity.Employee;
import com.java.training.hibernate.entity.Users;
import com.java.training.hibernate.util.HibernateUtilAnnotation;

public class Appp {

	public static void main(String[] args) {
		/*Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		session.beginTransaction();
		Employee e = getEmployee(session, 101);
		System.out.println("Saved Employee = " + e.toString());
		session.getTransaction().commit();
		session.close();*/
		
		Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		session.beginTransaction();
		getUser(session, "aashiq");
		//System.out.println(u);
		session.getTransaction().commit();
		session.close();
	}
	private static Users getUser(Session session, String username) {
		 Users employee = (Users)session.get(Users.class, new String(username));
	        System.out.println("Saved Employee = " + employee);
	        return employee;
	}
	@SuppressWarnings("unused")
	private static Employee getEmployee(Session session, int empId) {
		//check for existence
        Employee employee = (Employee)session.get(Employee.class, new Integer(empId));
        //System.out.println("Saved Employee = " + employee.toString());
        return employee;
 
	}
}
