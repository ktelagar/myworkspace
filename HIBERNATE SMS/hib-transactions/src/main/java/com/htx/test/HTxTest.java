package com.htx.test;

import com.htx.dao.BranchDao;
import com.htx.entities.Branch;

public class HTxTest {
	public static void main(String[] args) {
		Branch branch = null;
		BranchDao branchDao = null;
		
		branch = new Branch();
		branch.setBranchNo(1);
		branch.setBranchName("Ameerpet Branch");
		branch.setIfscCode("icic0000029");
		branch.setContactNo("98765252733");
		branch.setLocation("Hyderabad");
		branch.setWorkingHours("09:00 hours - 17:00 hours");
		
		branchDao = new BranchDao();
		branchDao.saveBranch(branch);
	}
}
