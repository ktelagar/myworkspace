package com.jpagen.test;

import com.jpagen.dao.BusDao;
import com.jpagen.entities.Bus;
import com.jpagen.helper.EntityManagerFactoryRegistry;

public class JPAGenTest {
	public static void main(String[] args) {
		try {
			BusDao busDao = new BusDao();
			Bus bus = new Bus();
			bus.setBusType("Semi-Sleeper");
			bus.setCapacity(36);
			bus.setRegistrationNo("TS09BQ9383");
			bus.setFuelType("diesel");
			bus.setColor("red");

			int busNo = busDao.saveBus(bus);
			System.out.println("bus no: " + busNo);
		} finally {
			EntityManagerFactoryRegistry.closeEntityManagerFactory("bus_mysql_pu");
		}
	}
}
