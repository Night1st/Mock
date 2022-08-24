package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.Trip;
import com.project.mock.utils.Connection;

public class TripSql {
	public List<Trip> findAllByPage(int page){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Trip");
		query.setMaxResults(3);
		query.setFirstResult((page-1)*3);
		@SuppressWarnings("unchecked")
		List<Trip> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<Trip> findAll(){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Trip");
		@SuppressWarnings("unchecked")
		List<Trip> list = query.getResultList();
		session.close();
		return list;
	}
	
	public Trip findById(Long id) {
		Session session = Connection.getFactory().openSession();
		Trip trip = session.get(Trip.class, id);
		session.close();
		return trip;
	}
	public List<Trip> search(String param){
		if(param == null || param.equals("")) {
			return findAllByPage(1);
		}
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select t FROM Trip t "
				+ "where t.carType like ?1 or t.destination like ?2 or t.driver like ?3");
		query.setParameter(1, "%"+param+"%");
		query.setParameter(2, "%"+param+"%");
		query.setParameter(3, "%"+param+"%");
		List<Trip> list = query.getResultList();
		
		session.close();
		return list;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From Trip");
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
	public void save(Trip trip) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(trip);
		session.getTransaction().commit();
		session.close();
	}
	public void update(Trip trip) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.update(trip);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Long id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		Trip trip = session.get(Trip.class, id);
		session.delete(trip);
		session.getTransaction().commit();
		session.close();
	}
}
