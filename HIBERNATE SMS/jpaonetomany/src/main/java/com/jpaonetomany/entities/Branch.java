package com.jpaonetomany.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "branch")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Branch implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_no")
	protected int branchNo;
	@Column(name = "branch_nm")
	protected String branchName;
	@Column(name = "branch_manager")
	protected String branchManager;
	protected String location;

	@OneToMany
	@JoinColumn(name = "branch_no")
	protected Set<Account> accounts;

}
