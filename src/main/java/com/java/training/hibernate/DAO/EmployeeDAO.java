package com.java.training.hibernate.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.java.training.hibernate.entity.Employee;
import com.java.training.hibernate.util.HibernateUtilAnnotation;

public class EmployeeDAO {
	
	public static List<Employee> getEmployee( String empId,String name) {
		Session session =HibernateUtilAnnotation.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Employee.class);
		Criterion id = null;
		Criterion fname = null;
		Criterion lname = null;
		int eid = 0;
		if(empId != null && !empId.isEmpty()){eid=Integer.parseInt(empId);}
		id = Restrictions.eq("id",eid );
		fname = Restrictions.ilike("fname","%"+name+"%" );
		lname = Restrictions.ilike("lname","%"+name+"%" );
		Disjunction exp = null;
		if(name != null && !name.isEmpty()){
			exp = Restrictions.or(id, fname,lname);
			criteria.add(exp);
		}else{
			
			criteria.add(id);
		}
		
		
		
		
		//System.out.println(criteria.list());
		@SuppressWarnings("unchecked")
		List<Employee> results = criteria.list();
		
		
		return results;
		/*String hql = "FROM Employee E WHERE E.id = " + empId;
		Query query = session.createQuery(hql);
		@SuppressWarnings({ "rawtypes" })
		List results = query.list();
		if (results.isEmpty()) { return null;}
		return (Employee) results.get(0);*/
 
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Employee> getAllEmployees(){
		Session session =HibernateUtilAnnotation.getSessionFactory().openSession();
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		List results = query.list();
		Iterator it = results.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		session.close();
		return results;
		
	}
	
	public static void deleteEmployee(String sid){
		Session session =HibernateUtilAnnotation.getSessionFactory().openSession();
		int id = Integer.parseInt(sid);
		String hql = "Delete from Employee where id="+id;
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();
		
	}
}
