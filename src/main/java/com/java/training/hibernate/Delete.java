package com.java.training.hibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.training.hibernate.DAO.EmployeeDAO;

public class Delete extends HttpServlet{

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] arr = req.getParameterValues("check");
		for(String a:arr){
			EmployeeDAO.deleteEmployee(a);
		}
		req.setAttribute("deleteMessage", "Deleted Successfully!!!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/search.jsp");
		rd.forward(req, resp);
	}
	
}
