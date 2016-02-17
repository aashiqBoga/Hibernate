package com.java.training.hibernate;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.training.hibernate.DAO.EmployeeDAO;
import com.java.training.hibernate.entity.Employee;

public class EmployeeSearch extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2331599185700818353L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if((req.getParameter("id") != null && !req.getParameter("id").isEmpty())||(req.getParameter("name") != null && !req.getParameter("name").isEmpty())){
	        List<Employee> e = EmployeeDAO.getEmployee(req.getParameter("id"),req.getParameter("name"));
	        if(e.size()!=0){
	        	req.setAttribute("employee",e);
		        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/result.jsp");
		        rd.forward(req, resp);
	        }else{
	        	req.setAttribute("error","*No employee found with the entered ID/name, please enter again!*");
		        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/search.jsp");
		        rd.forward(req, resp);
	        }
			}else{
				req.setAttribute("error","*Please Enter either id or name to search for employees*");
		        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/search.jsp");
		        rd.forward(req, resp);
			}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	List<Employee> e = EmployeeDAO.getAllEmployees();
	    	req.setAttribute("employee", e);
	    	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/result.jsp");
		        rd.forward(req, resp);		
	}

	
	
}
