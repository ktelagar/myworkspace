package com.otmoto.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmoto.entities.Account;
import com.otmoto.entities.Locker;
import com.otmoto.helper.SessionFactoryRegistry;

public class OTMOTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			Account account = new Account();
//			account.setAccountHolderName("George");
//			account.setAccountType("savings");
//			account.setOpenedDate(LocalDate.of(2021, 2, 23));
//			account.setBranchCode("BA03833");
//			account.setBalance(2400);
//
//			int accountNo = (Integer) session.save(account);
//			System.out.println("accountNo: " + accountNo);

//			Locker locker = new Locker();
//			locker.setKeyNo("k9898");
//			locker.setDimensions("24x12x24");
//			locker.setCharges(2000);
//			Account account = session.load(Account.class, 1);
//			locker.setAccount(account);
//			session.save(locker);

			Locker locker = session.get(Locker.class, 1);
			System.out.println(locker);

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
