package com.onetoonedirect.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetoonedirect.entities.InspectionReport;
import com.onetoonedirect.entities.VehicleInspection;
import com.onetoonedirect.helper.SessionFactoryRegistry;

public class OneToOneDirectTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			VehicleInspection vehicleInspection = new VehicleInspection();
//			vehicleInspection.setRtaRegistrationNo("TS09BI0838");
//			vehicleInspection.setEngineNo("E98933");
//			vehicleInspection.setChasisNo("CH939873");
//			vehicleInspection.setPurchaseDate(LocalDate.of(2019, 2, 21));
//			vehicleInspection.setModelName("Seltos");
//			vehicleInspection.setManufacturer("Kia");
//			vehicleInspection.setVehicleType("SUV");
//
//			int inspectionNo = (Integer) session.save(vehicleInspection);
//			System.out.println("inspection no : " + inspectionNo);

//			InspectionReport inspectionReport = new InspectionReport();
//			inspectionReport.setReportDate(LocalDate.of(2022, 6, 20));
//			inspectionReport.setAgentName("Alex");
//			inspectionReport.setDescription("Good Condition");
//			inspectionReport.setObservations("light scratches and dents");
//			inspectionReport.setRating(4);
//			inspectionReport.setReportExpiryDate(LocalDate.now().plusDays(15));
//			inspectionReport.setValuation(7000000);
//			
//			VehicleInspection vehicleInspection = session.load(VehicleInspection.class, 1);
//			
//			inspectionReport.setVehicleInspection(vehicleInspection);
//			session.save(inspectionReport);
			
			InspectionReport inspectionReport = session.get(InspectionReport.class, 1);
			System.out.println(inspectionReport);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
