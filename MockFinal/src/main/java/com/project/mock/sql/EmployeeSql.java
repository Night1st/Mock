package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.Employee;
import com.project.mock.utils.Connection;

public class EmployeeSql {
	public List<Employee> findAll (int page) {
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Employee");
		query.setMaxResults(3);
		query.setFirstResult((page-1) * 3);
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = query.getResultList();
		session.close();
		return employeeList;
	}
	
	public Employee findById(Long id) {
		Session session = Connection.getFactory().openSession();
		Employee e = session.get(Employee.class, id);
		session.close();
		return e;
	}
	
	public List<Employee> search (String param) {
		if(param == null || param.equals("")) {
			return findAll(1);
		}
		
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select emp FROM Employee emp "
				+ "where emp.account like ?1 or emp.department like ?2 or emp.employeeAddress like ?3 or emp.employeePhone like ?4 or emp.employeeName like ?5");
		query.setParameter(1, "%"+ param + "%");
		query.setParameter(2, "%"+ param + "%");
		query.setParameter(3, "%"+ param + "%");
		query.setParameter(4, "%"+ param + "%");
		query.setParameter(5, "%"+ param + "%");
		List<Employee> employeeList = query.getResultList();
		session.close();
		return employeeList;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From Employee");
		Long num = (Long) query.getSingleResult();
		session.close();
		if(num <= 3) {
			list.add(1L);
			return list;
		}
		else {
			Long page =  (Long) ((num % 3 == 0) ? num / 3 : num / 3+1);
			for(int i=1; i<=page; i++) {
				list.add((long) i);
			}
			return list;
		}
	}
	
	public void save(Employee employee) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Employee employee) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Long id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}
}
