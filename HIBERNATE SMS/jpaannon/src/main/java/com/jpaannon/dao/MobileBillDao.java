package com.jpaannon.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jpaannon.entities.MobileBill;
import com.jpaannon.helper.EntityManagerFactoryRegistry;

public class MobileBillDao {
	
	public void saveMobileBill(MobileBill mobileBill) {
		EntityTransaction entityTransaction = null;
		EntityManagerFactory emFactory = null;
		EntityManager entityManager = null;
		boolean flag = false;
		try {
			emFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager = emFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(mobileBill);

			flag = true;
		} finally {
			if (entityTransaction != null) {
				if (flag) {
					entityTransaction.commit();
				} else {
					entityTransaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}
}
