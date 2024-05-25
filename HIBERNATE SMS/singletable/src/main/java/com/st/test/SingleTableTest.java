package com.st.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.st.entities.CardPayment;
import com.st.entities.ChequePayment;
import com.st.entities.Payment;
import com.st.helper.EntityManagerFactoryRegistry;

public class SingleTableTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		boolean flag = false;
		int paymentNo = 0;

		try {
			entityManagerFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

		    //Payment payment = new Payment();
			//createPayment(payment, "Groceries purchase", new Date(), "Jane", 2300);
			//entityManager.persist(payment);
			//paymentNo = payment.getPaymentNo();
			//System.out.println("payment no : " + paymentNo);

			//CardPayment cardPayment = new CardPayment();
			//createPayment(cardPayment, "Clothing Merchandise", new Date(), "Adam", 5000);
			//cardPayment.setCardNo("768387679098");
			//cardPayment.setCardHolderName("Adam");
			//cardPayment.setExpiryDay(2);
			//cardPayment.setExpiryMonth(2024);
			//cardPayment.setIssuedBank("Citibank");
			//entityManager.persist(cardPayment);
			//System.out.println("payment no : " + cardPayment.getPaymentNo());

		//	ChequePayment chequePayment = new ChequePayment();
		//	createPayment(chequePayment, "Fashion and Jewellery", new Date(), "Phillip", 34000);
		//	chequePayment.setBankName("Hdfc Bank");
		//	chequePayment.setBranchName("Jubliee Hills");
		//	chequePayment.setChequeDate(new Date());
		//	chequePayment.setCustomerName("Phillip");
		//	chequePayment.setPayeeName("Lal Jewllerys");
		//	chequePayment.setChequeNo("BL38933");
		//	entityManager.persist(chequePayment);
		//	paymentNo = chequePayment.getPaymentNo();
		//	System.out.println("payment no : " + chequePayment.getPaymentNo());

		//	CardPayment payment = entityManager.find(CardPayment.class, 2);
		//	System.out.println(payment);
			
			Payment payment = entityManager.find(Payment.class, 3);
			 System.out.println(payment);
			 

			flag = true;
		} finally {
			if (entityTransaction != null) {
				if (flag) {
					entityTransaction.commit();
				} else {
					entityTransaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
			EntityManagerFactoryRegistry.closeEntityManagerFactory();
		}
	}

	private static void createPayment(Payment payment, String description, Date paymentDate, String customerName,
			double amount) {
		payment.setDescription(description);
		payment.setPaymentDate(paymentDate);
		payment.setCustomerName(customerName);
		payment.setPaidAmount(amount);
	}
}
