package com.onetomanylist.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Token implements Serializable {
	protected int tokenNo;
	protected String serviceType;
	protected String problem;
	protected LocalDateTime tokenIssuedDate;
	protected String customerName;
	protected String mobileNo;

}
