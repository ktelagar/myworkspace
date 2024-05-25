package com.jpack.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpack.entities.EduScholarship;
import com.jpack.entities.EduScholarshipNo;

public class JPACKTest {
	public static void main(String[] args) {
		EduScholarshipNo eduScholarshipNo = null;
		EduScholarship eduScholarship = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("scholarshippu");
			em = emf.createEntityManager();
			eduScholarshipNo = new EduScholarshipNo();
			eduScholarshipNo.setEduscno(736);
			eduScholarshipNo.setCollegeCode("DN098937");
			eduScholarshipNo.setAadharNo("A9383900");

			eduScholarship = em.find(EduScholarship.class, eduScholarshipNo);
			System.out.println(eduScholarship);
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
