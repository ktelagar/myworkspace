package com.msf.test;

import com.msf.dao.ProductDao;
import com.msf.entities.Product;
import com.msf.helper.SessionFactoryRegistry;

public class ManageSessionFactoryTest {
	public static void main(String[] args) {
		ProductDao productDao = null;
		Product product = null;
		
		try {
			productDao = new ProductDao();
			product = productDao.getProduct(1);
			System.out.println(product);
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
