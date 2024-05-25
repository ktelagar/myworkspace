package com.jpaonetomany.test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jpaonetomany.entities.Account;
import com.jpaonetomany.entities.Branch;
import com.jpaonetomany.helper.EntityManagerFactoryRegistry;

public class JpaOneToManyTest {
	public static void main(String[] args) {
		EntityTransaction entityTransaction = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		boolean flag = false;

		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory("hib_pu");
			em = emf.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			Account account = Account.builder().accountHolderName("Frank").accountType("savings").balance(3450).build();
			em.persist(account);
			Set<Account> accounts = Stream.of(new Account[] { account }).collect(Collectors.toSet());
			Branch branch = Branch.builder().branchName("Axisbank Punjagutta").branchManager("Joe")
					.location("punjagutta").accounts(accounts).build();
			em.persist(branch);
			
			/*
			 * Branch branch = em.find(Branch.class, 4); System.out.println(branch);
			 */

			flag = true;
		} finally {
			if (entityTransaction != null) {
				if (flag) {
					entityTransaction.commit();
				} else {
					entityTransaction.rollback();
				}
			}
			if (em != null) {
				em.close();
			}
		}
	}
}
