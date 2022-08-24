package com.project.mock.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.project.mock.model.Ticket;
import com.project.mock.utils.Connection;

public class TicketSql {
	public List<Ticket> findAll(int page){
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("From Ticket");
		query.setMaxResults(3);
		query.setFirstResult((page-1)*3);
		@SuppressWarnings("unchecked")
		List<Ticket> list = query.getResultList();
		session.close();
		return list;
	}
	
	public List<Long> numPage() {
		List<Long> list = new ArrayList<Long>();
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("select count(*) From Ticket");
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
	
	public List<Ticket> search(String param){
		if(param == null || param.equals("")) {
			return findAll(1);
		}
		Session session = Connection.getFactory().openSession();
		Query query = session.createQuery("Select b FROM Ticket b "
				+ "where b.customerName like ?1 or b.car.licensePlate like ?2 or b.trip.destination like ?3");
		query.setParameter(1, "%"+param+"%");
		query.setParameter(2, "%"+param+"%");
		query.setParameter(3, "%"+param+"%");
		List<Ticket> list = query.getResultList();
		
		session.close();
		return list;
	}
	
	public void save(Ticket ticket) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		session.save(ticket);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Long id) {
		Session session = Connection.getFactory().openSession();
		session.getTransaction().begin();
		Ticket ticket = session.get(Ticket.class, id);
		session.delete(ticket);
		session.getTransaction().commit();
		session.close();
	}
}
