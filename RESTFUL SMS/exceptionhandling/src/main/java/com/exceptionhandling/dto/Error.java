package com.exceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class Error {
	private int errorCode;
	private String errorMessage;
}
