package com.java.training.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.java.training.hibernate.entity.Employee;
import com.java.training.hibernate.entity.Users;

public class HibernateUtilAnnotation {
	private static final SessionFactory factory=buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory(){
		try{
			
			/*return new AnnotationConfiguration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class)
					.buildSessionFactory();*/
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Users.class);
	        //Configuration configuration = new Configuration().addAnnotatedClass(Employee1.class);
	        
	        System.out.println("Hibernate Annotation Configuration loaded");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        System.out.println("Hibernate Annotation serviceRegistry created");
	        return configuration.buildSessionFactory(serviceRegistry);
	        
		}
		catch (Throwable ex){
			  // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
		
	
	}
	
	
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}
}

