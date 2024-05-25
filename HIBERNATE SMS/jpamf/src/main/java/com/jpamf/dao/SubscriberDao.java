package com.jpamf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.jpamf.entities.Subscriber;
import com.jpamf.helper.EntityManagerFactoryRegistry;

public class SubscriberDao {
	public Subscriber getSubscriber(int subscriberNo) {
		EntityManagerFactory emFactory = null;
		EntityManager entityManager = null;
		Subscriber subscriber = null;

		try {
			emFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager = emFactory.createEntityManager();
			subscriber = entityManager.find(Subscriber.class, subscriberNo);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return subscriber;
	}
}
