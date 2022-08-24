package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.ParkingLot;
import com.project.mock.utils.Connection;

public class ParkingLotSql {
	public List<ParkingLot> findAll(int page){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From ParkingLot");
		query.setMaxResults(3);
		query.setFirstResult((page-1)*3);
		@SuppressWarnings("unchecked")
		List<ParkingLot> list = query.getResultList();
		session.close();
		return list;
	}
	
	public ParkingLot findById(Long id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		ParkingLot p = session.get(ParkingLot.class, id);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	
	public List<ParkingLot> findAll(){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From ParkingLot");
		@SuppressWarnings("unchecked")
		List<ParkingLot> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<ParkingLot> search(String param){
		if(param == null || param.equals("")) {
			return findAll(1);
		}
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select p FROM ParkingLot p "
				+ "where p.parkName like ?1 or p.parkPlace like ?2");
		query.setParameter(1, "%"+param+"%");
		query.setParameter(2, "%"+param+"%");
		List<ParkingLot> list = query.getResultList();
		
		session.close();
		return list;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From ParkingLot");
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
	
	public void save(ParkingLot parking) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(parking);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(ParkingLot parking) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.update(parking);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Long id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		ParkingLot p = session.get(ParkingLot.class, id);
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}
}
