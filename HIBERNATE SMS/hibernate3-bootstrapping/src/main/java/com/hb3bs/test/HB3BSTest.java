package com.hb3bs.test;

import com.hb3bs.dao.PolicyDao;
import com.hb3bs.entities.Policy;
import com.hb3bs.helper.PropsSessionFactoryRegistry;
import com.hb3bs.helper.XmlSessionFactoryRegistry;

public class HB3BSTest {
	public static void main(String[] args) {
		try {
			PolicyDao policyDao = new PolicyDao();
			Policy policy = policyDao.getPolicy(123);
			System.out.println(policy);
		} finally {
			XmlSessionFactoryRegistry.closeSessionFactory();
		}
	}
}
