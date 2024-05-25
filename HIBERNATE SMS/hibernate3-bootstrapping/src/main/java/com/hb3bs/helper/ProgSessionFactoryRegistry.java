package com.hb3bs.helper;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProgSessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("connection.url", "jdbc:mysql://localhost:3306/hibdb");
			configuration.setProperty("connection.username", "root");
			configuration.setProperty("connection.password", "root");
			configuration.setProperty("show_sql", "true");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.addResource("com/hb3bs/entities/Policy.hbm.xml");

			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
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
