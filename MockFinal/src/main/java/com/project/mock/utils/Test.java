package com.project.mock.utils;

import org.hibernate.Session;

public class Test {
	
	public static void main(String[] args) {
		Session s = Connection.getFactory().openSession();

		s.close();
	}
}
