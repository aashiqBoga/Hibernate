package com.java.training.hibernate.DAO;

import org.hibernate.Session;

import com.java.training.hibernate.entity.Users;
import com.java.training.hibernate.util.HibernateUtilAnnotation;

public class UsersDAO {
	public static boolean validate(String username, String password){
		Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		session.beginTransaction();
		Users user = (Users)session.get(Users.class, new String(username));
        if(user==null){return false;}
        
		if(user.getPassword().equals(password)){
			session.getTransaction().commit();
			session.close();
			return true;
		}
        
		else{
			session.getTransaction().commit();
			session.close();
			return false;
			}
		
        }
	
	
}
