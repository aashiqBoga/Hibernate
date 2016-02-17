package com.java.training.hibernate;

import java.util.List;

import com.java.training.hibernate.DAO.EmployeeDAO;
import com.java.training.hibernate.DAO.UsersDAO;
import com.java.training.hibernate.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		
		
		System.out.println(UsersDAO.validate("test", "pass123"));

	}

}
