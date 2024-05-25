package com.jpagen.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jpagen.entities.Bus;
import com.jpagen.helper.EntityManagerFactoryRegistry;

public class BusDao {
	public int saveBus(Bus bus) {
		EntityTransaction entityTransaction = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		int busNo = 0;
		boolean flag = false;

		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory("bus_mysql_pu");
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			em.persist(bus);
			busNo = bus.getBusNo();

			flag = true;
		} finally {
			if (entityTransaction != null) {
				if (flag) {
					entityTransaction.commit();
				} else {
					entityTransaction.rollback();
				}
			}
			if (em != null) {
				em.close();
			}
		}

		return busNo;
	}
}
