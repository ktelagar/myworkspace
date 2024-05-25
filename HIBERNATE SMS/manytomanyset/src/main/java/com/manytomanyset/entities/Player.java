package com.manytomanyset.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
	protected int playerNo;
	protected String playerName;
	protected int rank;
	protected LocalDate dob;
	protected String gender;
	protected String nationality;
	protected Set<Team> teams;

}
