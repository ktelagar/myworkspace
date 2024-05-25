package com.joined.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryRegistry {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("paymentPU");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}

}
