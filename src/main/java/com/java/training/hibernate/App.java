package com.java.training.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.java.training.hibernate.entity.Employee;
import com.java.training.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        //get Employee
        /*Employee empSaved = getEmployee(session, 101);
        System.out.println("Saved Employee = " + empSaved.toString());
        */
        //get Employee by Id - query interface
        Employee empSaved2 = getEmployeeById(session, 102);
        System.out.println("Saved Employee = " + empSaved2);
  
        //Save Employee
        //saveEmployee(session, 101);
        
        //get Employees whose age is > 30
//        List <Employee> below30Employees = getEmployeeByAge(session, 30);
//        System.out.println("Employees Below  30  = " + below30Employees.size());
        //saveEmployee(session, 101);
        session.getTransaction().commit();
        
        //System.out.println("Inserted record successfully");
 	}
	
	@SuppressWarnings("unused")
	private static void saveEmployee(Session session, int id) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setFname("Hibernate");
        emp.setLname("Example");
        emp.setAge(50);
        emp.setAddress("Sample Hibernate Address \nSome City, State Zipcode");
        session.save(emp);
  		
	}
	
	
	@SuppressWarnings("unused")
	private static Employee getEmployee(Session session, int empId) {
		//check for existence
        Employee employee = session.get(Employee.class, new Integer(empId));
        //System.out.println("Saved Employee = " + employee.toString());
        return employee;
 
	}
	
	private static Employee getEmployeeById(Session session, int empId) {
		String hql = "FROM Employee E WHERE E.id = " + empId;
		Query query = session.createQuery(hql);
		@SuppressWarnings({ "rawtypes" })
		List results = query.list();
		if (results.isEmpty()) { return null;}
		return (Employee) results.get(0);
	}
	
	@SuppressWarnings("unused")
	private static List <Employee> getEmployeeByAge(Session session, int age) {
		Criteria cr = session.createCriteria(Employee.class);

		// To get records having age less than passed age
		//cr.add(Restrictions.lt("age", age));
		
		Criterion name = Restrictions.ilike("fname","Employee%");
		Criterion salary = Restrictions.lt("age", age);

		// To get records matching with OR condistions
		//LogicalExpression orExp = Restrictions.or(salary, name);
		//cr.add( orExp );
		
		LogicalExpression andExp = Restrictions.and(salary, name);
		cr.add( andExp );

		@SuppressWarnings("unchecked")
		List <Employee>results = cr.list();
		return results;
	}
}
