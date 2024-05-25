package com.hb3bs.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropsSessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration(); // default constructor has the logic for reading the
															// properties file
		configuration.addResource("com/hb3bs/entities/Policy.hbm.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
