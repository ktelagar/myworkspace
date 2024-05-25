package com.onetomanylist.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetomanylist.entities.ServiceCenter;
import com.onetomanylist.entities.Token;
import com.onetomanylist.helper.SessionFactoryRegistry;

public class OneToManyListTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Token token1 = Token.builder().serviceType("In_Warranty").problem("slow")
					.tokenIssuedDate(LocalDateTime.now()).customerName("paul").mobileNo("9897636738").build();
			session.save(token1);
			Token token2 = Token.builder().serviceType("In_Warranty").problem("network issue")
					.tokenIssuedDate(LocalDateTime.now()).customerName("peter").mobileNo("73689488").build();
			session.save(token2);
			Token token3 = Token.builder().serviceType("In_Warranty").problem("display")
					.tokenIssuedDate(LocalDateTime.now()).customerName("greg").mobileNo("83937899").build();
			session.save(token3);
			Token token4 = Token.builder().serviceType("OutOfWarranty").problem("battery")
					.tokenIssuedDate(LocalDateTime.now()).customerName("lisa").mobileNo("659008379").build();
			session.save(token4);

			List<Token> tokens1 = Arrays.asList(new Token[] { token1, token2 });
			ServiceCenter sc1 = ServiceCenter.builder().serviceCenterName("Samsung Venkateswara Kphb Center")
					.company("samsung").branchManager("Tim").contactNo("892878379")
					.emailAddress("samsungkphb@gmail.com").location("kukatpally").tokens(tokens1).build();

			List<Token> tokens2 = Arrays.asList(new Token[] { token3, token4 });
			ServiceCenter sc2 = ServiceCenter.builder().serviceCenterName("Samsung Bhavani Abids Center")
					.company("samsung").branchManager("Basha").contactNo("86289073")
					.emailAddress("samsungabids@gmail.com").location("abids").tokens(tokens2).build();
			session.save(sc1);
			session.save(sc2);

			//ServiceCenter sc1 = session.get(ServiceCenter.class, 1);
			//System.out.println(sc1);

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
