package com.apc.dto;

public class TrackingNo {
	private String sourceBranchCode;
	private String destinationBranchCode;
	private int uniqueNo;

	/*
	 * public TrackingNo(String trackingNo) { sourceBranchCode =
	 * trackingNo.substring(0, 3); destinationBranchCode = trackingNo.substring(3,
	 * 6); uniqueNo = Integer.parseInt(trackingNo.substring(6, 11)); }
	 */

	public String getSourceBranchCode() {
		return sourceBranchCode;
	}

	public void setSourceBranchCode(String sourceBranchCode) {
		this.sourceBranchCode = sourceBranchCode;
	}

	public String getDestinationBranchCode() {
		return destinationBranchCode;
	}

	public void setDestinationBranchCode(String destinationBranchCode) {
		this.destinationBranchCode = destinationBranchCode;
	}

	public int getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(int uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

	public static TrackingNo valueOf(String trackingNo) {
		TrackingNo trackingNo2 = new TrackingNo();
		trackingNo2.setSourceBranchCode(trackingNo.substring(0, 3));
		trackingNo2.setDestinationBranchCode(trackingNo.substring(3, 6));
		trackingNo2.setUniqueNo(Integer.parseInt(trackingNo.substring(6, 11)));

		return trackingNo2;
	}

	@Override
	public String toString() {
		return "TrackingNo [sourceBranchCode=" + sourceBranchCode + ", destinationBranchCode=" + destinationBranchCode
				+ ", uniqueNo=" + uniqueNo + "]";
	}

}
