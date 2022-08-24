package com.project.mock.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.project.mock.model.BookingOffice;
import com.project.mock.model.Car;
import com.project.mock.model.Employee;
import com.project.mock.model.ParkingLot;
import com.project.mock.model.Ticket;
import com.project.mock.model.Trip;


public class Connection {
	private final static SessionFactory FACTORY;
	
	static {
		Configuration config = new Configuration();
		Properties prop = new Properties();
		
		prop.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
		prop.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:orcl");
		prop.put(Environment.USER, "Long1234");
		prop.put(Environment.PASS, "Long1234");
		prop.put(Environment.DIALECT, "org.hibernate.dialect.Oracle8iDialect");
		prop.put(Environment.SHOW_SQL, "true");
		config.addAnnotatedClass(Employee.class);
		config.addAnnotatedClass(Car.class);
		config.addAnnotatedClass(BookingOffice.class);
		config.addAnnotatedClass(ParkingLot.class);
		config.addAnnotatedClass(Trip.class);
		config.addAnnotatedClass(Ticket.class);
		config.setProperties(prop);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		FACTORY = config.buildSessionFactory(registry);
	
	}
	
	public static SessionFactory getFactory() {
		return FACTORY;
	}
}
