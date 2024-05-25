package com.cpc.dto;

public class AwbNo {
	private String cityCode;
	private String branchCode;
	private int bookedDate;
	private int seq;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public int getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(int bookedDate) {
		this.bookedDate = bookedDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "AwbNo [cityCode=" + cityCode + ", branchCode=" + branchCode + ", bookedDate=" + bookedDate + ", seq="
				+ seq + "]";
	}

}
