package com.jtpc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chequepayment")
public class ChequePayment extends Payment {
	@Column(name = "cheque_no")
	protected String chequeNo;
	@Column(name = "bank_nm")
	protected String bankName;
	@Column(name = "branch_nm")
	protected String branchName;
	@Column(name = "payee_nm")
	protected String payeeName;
	@Column(name = "cheque_dt")
	protected Date chequeDate;

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((chequeDate == null) ? 0 : chequeDate.hashCode());
		result = prime * result + ((chequeNo == null) ? 0 : chequeNo.hashCode());
		result = prime * result + ((payeeName == null) ? 0 : payeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChequePayment other = (ChequePayment) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (chequeDate == null) {
			if (other.chequeDate != null)
				return false;
		} else if (!chequeDate.equals(other.chequeDate))
			return false;
		if (chequeNo == null) {
			if (other.chequeNo != null)
				return false;
		} else if (!chequeNo.equals(other.chequeNo))
			return false;
		if (payeeName == null) {
			if (other.payeeName != null)
				return false;
		} else if (!payeeName.equals(other.payeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", bankName=" + bankName + ", branchName=" + branchName
				+ ", payeeName=" + payeeName + ", chequeDate=" + chequeDate + ", paymentNo=" + paymentNo
				+ ", description=" + description + ", customerName=" + customerName + ", paymentDate=" + paymentDate
				+ ", paidAmount=" + paidAmount + "]";
	}

}
