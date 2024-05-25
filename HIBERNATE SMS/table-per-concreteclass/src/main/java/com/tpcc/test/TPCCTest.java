package com.tpcc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpcc.entities.InsurancePlan;
import com.tpcc.helper.SessionFactoryRegistry;

public class TPCCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		int planNo = 0;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			InsurancePlan insurancePlan = new InsurancePlan();
//			insurancePlan.setPlanName("Jeevan Bheema");
//			insurancePlan.setDescription("lifesaver plan");
//			insurancePlan.setTaxSaver(true);
//			insurancePlan.setMinInsurredAmount(100000);
//
//			planNo = (Integer) session.save(insurancePlan);

//			AccidentalInsurancePlan insurancePlan = new AccidentalInsurancePlan();
//			insurancePlan.setPlanName("Jeevan Travel");
//			insurancePlan.setDescription("Accident Saver plan");
//			insurancePlan.setTaxSaver(false);
//			insurancePlan.setMinInsurredAmount(1000000);
//			insurancePlan.setCoverageType("international");
//			insurancePlan.setDisabilityCoveragePercentage(50);
//			insurancePlan.setMinInsurredAmount(100000);
//
//			planNo = (Integer) session.save(insurancePlan);

//			MedicalInsurancePlan insurancePlan = new MedicalInsurancePlan();
//			insurancePlan.setPlanName("Jeevan Abhaya");
//			insurancePlan.setDescription("Medical Saver plan");
//			insurancePlan.setTaxSaver(false);
//			insurancePlan.setMinInsurredAmount(4000000);
//			insurancePlan.setNetworkType("in-network");
//			insurancePlan.setCopay(10);
//			
//			planNo = (Integer) session.save(insurancePlan);
//			System.out.println("plan no: " + planNo);

//			AccidentalInsurancePlan insurancePlan = session.get(AccidentalInsurancePlan.class, 3);
			InsurancePlan insurancePlan = session.get(InsurancePlan.class, 3);
//			
			System.out.println(insurancePlan);
			
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
