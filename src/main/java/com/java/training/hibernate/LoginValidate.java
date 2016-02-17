package com.java.training.hibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.training.hibernate.DAO.UsersDAO;

public class LoginValidate extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2140367060439537052L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(UsersDAO.validate(req.getParameter("username"), req.getParameter("password"))){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/search.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			String error = "*Invalid username/password entered.Please enter again*";
			req.setAttribute("error", error);
			rd.forward(req, resp);
		}
	}
	
	
	
}
