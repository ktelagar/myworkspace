package com.joined.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.joined.entities.CardPayment;
import com.joined.entities.ChequePayment;
import com.joined.entities.Payment;
import com.joined.helper.EntityManagerFactoryRegistry;

public class JoinedTest {
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

//			Payment payment = new Payment();
//			createPayment(payment, "Groceries", new Date(), "Jane", 500);
//			entityManager.persist(payment);
//			paymentNo = payment.getPaymentNo();
//			System.out.println("payment no :" + paymentNo);

//			CardPayment payment = new CardPayment();
//			createPayment(payment, "Clothing Merchandise", new Date(), "Adam", 3000);
//			payment.setCardNo("7883827393730283");
//			payment.setCardHolderName("Adam");
//			payment.setExpiryDay(2);
//			payment.setExpiryMonth(2022);
//			payment.setIssuedBank("Icici Bank");
//			entityManager.persist(payment);
//			paymentNo = payment.getPaymentNo();
//			System.out.println("payment no :" + paymentNo);

//			ChequePayment payment = new ChequePayment();
//			createPayment(payment, "Fashion and Jewllery", new Date(), "Phillip", 230000);
//			payment.setBankName("Hdfc Bank");
//			payment.setBranchName("Jubliee Hills");
//			payment.setChequeNo("BLu3803");
//			payment.setChequeDate(new Date());
//			payment.setPayeeName("Lal Jewllerys");
//			entityManager.persist(payment);
//			paymentNo = payment.getPaymentNo();
//			System.out.println("payment no :" + paymentNo);

//			ChequePayment payment = entityManager.find(ChequePayment.class, 3);
//			System.out.println(payment);

			Payment payment = entityManager.find(Payment.class, 2);
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
			float paidAmount) {
		payment.setDescription(description);
		payment.setCustomerName(customerName);
		payment.setPaymentDate(paymentDate);
		payment.setPaidAmount(paidAmount);
	}
}
