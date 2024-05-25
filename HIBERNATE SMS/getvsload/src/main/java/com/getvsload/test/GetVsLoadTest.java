package com.getvsload.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.getvsload.entities.Customer;
import com.getvsload.entities.ICustomer;
import com.getvsload.helper.SessionFactoryRegistry;

public class GetVsLoadTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null; 
		ICustomer customer = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			
			customer = session.load(Customer.class, 1);
			session.close();
			session = null;
			System.out.println("customer class: " + customer.getClass().getName());
			System.out.println("customer name: " +  customer.getCustomerName());
		} finally {
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}








