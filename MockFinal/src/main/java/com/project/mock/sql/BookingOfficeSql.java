package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.BookingOffice;
import com.project.mock.utils.Connection;

public class BookingOfficeSql {
	public List<BookingOffice> findAll(int page){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From BookingOffice");
		query.setMaxResults(3);
		query.setFirstResult((page-1)*3);
		@SuppressWarnings("unchecked")
		List<BookingOffice> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<BookingOffice> search(String param){
		if(param == null || param.equals("")) {
			return findAll(1);
		}
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select b FROM BookingOffice b "
				+ "where b.officeName like ?1 or b.officePhone like ?2 or b.officePlace like ?3");
		query.setParameter(1, "%"+param+"%");
		query.setParameter(2, "%"+param+"%");
		query.setParameter(3, "%"+param+"%");
		List<BookingOffice> list = query.getResultList();
		
		session.close();
		return list;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From BookingOffice");
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
	public void save(BookingOffice booking) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(booking);
		session.getTransaction().commit();
		session.close();
	}
}
