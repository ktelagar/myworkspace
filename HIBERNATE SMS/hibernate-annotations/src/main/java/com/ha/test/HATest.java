package com.ha.test;

import com.ha.dao.StaffDao;
import com.ha.entities.Staff;
import com.ha.helper.SessionFactoryRegistry;

public class HATest {
	public static void main(String[] args) {
		StaffDao staffDao = new StaffDao();

		try {
			Staff staff = staffDao.getStaff(1);
			System.out.println(staff);
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
