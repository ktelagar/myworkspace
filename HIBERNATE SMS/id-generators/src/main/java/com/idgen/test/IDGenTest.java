package com.idgen.test;

import com.idgen.dao.VehicleDao;
import com.idgen.entities.Vehicle;
import com.idgen.helper.SessionFactoryRegistry;

public class IDGenTest {
	public static void main(String[] args) {
		VehicleDao dao = new VehicleDao();

		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setModelName("mustang");
			vehicle.setManufacturer("Ford");
			vehicle.setRegistrationNo("TS089383");
			vehicle.setColor("yellow");
			vehicle.setFuelType("Petrol");
			vehicle.setLeaseAmount(35000);
			String vno = dao.saveVehicle(vehicle);

			System.out.println("vehicle no : " + vno);

			
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
