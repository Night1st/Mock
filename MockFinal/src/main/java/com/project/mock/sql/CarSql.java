package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.Car;
import com.project.mock.utils.Connection;

public class CarSql {
	public List<Car> findAll(int page){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Car");
		query.setMaxResults(3);
		query.setFirstResult((page-1)*3);
		@SuppressWarnings("unchecked")
		List<Car> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<Car> findAll(){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Car");
		@SuppressWarnings("unchecked")
		List<Car> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<Car> search(String param){
		if(param == null || param.equals("")) {
			return findAll(1);
		}
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select c FROM Car c "
				+ "where c.licensePlate like ?1 or c.carColor like ?2 or c.carType like ?3 or c.company like ?4");
		query.setParameter(1, "%"+param+"%");
		query.setParameter(2, "%"+param+"%");
		query.setParameter(3, "%"+param+"%");
		query.setParameter(4, "%"+param+"%");
		List<Car> list = query.getResultList();
		
		session.close();
		return list;
	}
	
	public Car findById(String id) {
		Session session = Connection.getFactory().openSession();
		Car c = session.get(Car.class, id);
		session.close();
		return c;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From Car");
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
	
	public void save(Car car) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void delete(String id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		Car car = session.get(Car.class, id);
		session.delete(car);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Car car) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.update(car);
		session.getTransaction().commit();
		session.close();
	}
}

