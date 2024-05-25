package com.jpagen.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryRegistry {
	private static Map<String, EntityManagerFactory> entityManagerFactoryMap = new ConcurrentHashMap<String, EntityManagerFactory>();

	public static EntityManagerFactory getEntityManagerFactory(String puName) {
		EntityManagerFactory emf = null;
		if (entityManagerFactoryMap.containsKey(puName) == false) {
			synchronized (entityManagerFactoryMap) {
				if (entityManagerFactoryMap.containsKey(puName) == false) {
					emf = Persistence.createEntityManagerFactory(puName);
					entityManagerFactoryMap.put(puName, emf);
				}
			}
		}
		emf = entityManagerFactoryMap.get(puName);
		return emf;
	}

	public static void closeEntityManagerFactory(String puName) {
		if (entityManagerFactoryMap.containsKey(puName) == true) {
			entityManagerFactoryMap.get(puName).close();
		}
	}
}
