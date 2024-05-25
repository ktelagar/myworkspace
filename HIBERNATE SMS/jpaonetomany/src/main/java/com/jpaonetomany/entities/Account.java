package com.jpaonetomany.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "account")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
	@Id
	@Column(name = "account_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int accountNo;
	@Column(name = "account_holder_nm")
	protected String accountHolderName;
	@Column(name = "account_type")
	protected String accountType;
	protected double balance;

}
