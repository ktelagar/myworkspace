package com.jpaannon.test;

import java.util.Date;

import com.jpaannon.dao.MobileBillDao;
import com.jpaannon.entities.MobileBill;

public class JPAAnnonTest {
	public static void main(String[] args) {
		MobileBillDao dao = new MobileBillDao();
		MobileBill mobileBill = new MobileBill();
		
		mobileBill.setBillNo(2);
		mobileBill.setSubscriberName("kerry");
		mobileBill.setMobileNo("88378933");
		mobileBill.setSubscriptionType("postpaid");
		mobileBill.setBillDate(new Date());
		mobileBill.setDueDate(new Date());
		mobileBill.setBillAmount(1001);
		
		dao.saveMobileBill(mobileBill);
	}
}
