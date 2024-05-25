package com.criteriaapi.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryHelper {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cqpu");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void closeEmf() {
		if (emf != null) {
			emf.close();
		}
	}
}
