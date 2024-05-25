package com.tpch.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpch.entities.AccidentalInsurancePlan;
import com.tpch.entities.InsurancePlan;
import com.tpch.entities.MedicalInsurancePlan;
import com.tpch.helper.SessionFactoryRegistry;

public class TPCHTest {
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
			/*
			 * InsurancePlan insurancePlan = new InsurancePlan();
			 * insurancePlan.setPlanName("Jeevan Bheema");
			 * insurancePlan.setDescription("lifesaver plan");
			 * insurancePlan.setTaxSaver(true); insurancePlan.setMinInsurredAmount(100000);
			 * 
			 * planNo = (Integer) session.save(insurancePlan);
			 */

			/*
			 * AccidentalInsurancePlan insurancePlan = new AccidentalInsurancePlan();
			 * insurancePlan.setPlanName("Jeevan Travel");
			 * insurancePlan.setDescription("Accident Saver plan");
			 * insurancePlan.setTaxSaver(false);
			 * insurancePlan.setMinInsurredAmount(1000000);
			 * insurancePlan.setCoverageType("international");
			 * insurancePlan.setDisabilityCoveragePercentage(50); planNo = (Integer)
			 * session.save(insurancePlan);
			 */
			/*
			 * MedicalInsurancePlan insurancePlan = new MedicalInsurancePlan();
			 * insurancePlan.setPlanName("Jeevan Abhaya");
			 * insurancePlan.setDescription("Medical Saver plan");
			 * insurancePlan.setTaxSaver(false);
			 * insurancePlan.setMinInsurredAmount(4000000);
			 * insurancePlan.setNetworkType("in-network"); insurancePlan.setCopay(10);
			 * 
			 * planNo = (Integer) session.save(insurancePlan);
			 * System.out.println("plan no: " + planNo);
			 */

			InsurancePlan usingParentRefForChildRec1 = session.get(InsurancePlan.class, 4);
			InsurancePlan usingParentRefForChildRec2 = session.get(MedicalInsurancePlan.class, 4);
			MedicalInsurancePlan usingParentRefForChildRecAndCasting = (MedicalInsurancePlan) session.get(InsurancePlan.class, 4);
			
			AccidentalInsurancePlan referringToWrongID = session.get(AccidentalInsurancePlan.class, 1); //1 Belongs to parent record
			//AccidentalInsurancePlan usingChildForParentRec2 = session.get(InsurancePlan.class, 1); //CE
			
			AccidentalInsurancePlan insurancePlan3 = session.get(AccidentalInsurancePlan.class, 3);
			MedicalInsurancePlan insurancePlan4 = session.get(MedicalInsurancePlan.class, 4);
			
			
			
			System.out.println("usingParentRefForChildRec1 ::"+usingParentRefForChildRec1);
			System.out.println("usingParentRefForChildRec2 ::"+usingParentRefForChildRec2);
			System.out.println("referringToWrongID ::"+referringToWrongID);
			System.out.println("insurancePlan3 ::"+insurancePlan3);
			System.out.println("insurancePlan4 ::"+insurancePlan4);
			System.out.println("usingParentRefForChildRecAndCasting ::"+usingParentRefForChildRecAndCasting);
			
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
