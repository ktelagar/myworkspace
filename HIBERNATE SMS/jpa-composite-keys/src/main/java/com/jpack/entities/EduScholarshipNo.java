package com.jpack.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EduScholarshipNo implements Serializable {
	protected int eduscno;
	@Column(name = "college_code")
	protected String collegeCode;
	@Column(name = "aadhar_no")
	protected String aadharNo;

	public int getEduscno() {
		return eduscno;
	}

	public void setEduscno(int eduscno) {
		this.eduscno = eduscno;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aadharNo, collegeCode, eduscno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EduScholarshipNo other = (EduScholarshipNo) obj;
		return Objects.equals(aadharNo, other.aadharNo) && Objects.equals(collegeCode, other.collegeCode)
				&& eduscno == other.eduscno;
	}

	@Override
	public String toString() {
		return "EduScholarshipNo [eduscno=" + eduscno + ", collegeCode=" + collegeCode + ", aadharNo=" + aadharNo + "]";
	}

}
