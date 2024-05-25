package com.manytomanyset.entities;

import java.io.Serializable;
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
@EqualsAndHashCode(exclude = "players")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team implements Serializable {
	protected int teamNo;
	protected String teamName;
	protected String description;
	protected String representationCountry;
	protected String coach;
	protected String captain;
	protected Set<Player> players;
}
