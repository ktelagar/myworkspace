package com.jpamf.test;

import com.jpamf.dao.SubscriberDao;
import com.jpamf.entities.Subscriber;
import com.jpamf.helper.EntityManagerFactoryRegistry;

public class JPAMFTest {
	public static void main(String[] args) {
		try {
			SubscriberDao dao = new SubscriberDao();
			Subscriber subscriber = dao.getSubscriber(1);
			System.out.println(subscriber);
		} finally {
			EntityManagerFactoryRegistry.closeEntityManagerFactory();
		}
	}
}
