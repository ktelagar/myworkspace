package com.cpc.converters;

import com.cpc.dto.AwbNo;

import jakarta.ws.rs.ext.ParamConverter;

public class AwbNoParamConverter implements ParamConverter<AwbNo> {

	@Override
	public AwbNo fromString(String value) {
		AwbNo awbNo = new AwbNo();
		awbNo.setCityCode(value.substring(0, 3));
		awbNo.setBranchCode(value.substring(3, 7));
		awbNo.setBookedDate(Integer.parseInt(value.substring(7, 13)));
		awbNo.setSeq(Integer.parseInt(value.substring(13, 19)));
		return awbNo;
	}

	@Override
	public String toString(AwbNo value) {
		return value.toString();
	}

}
