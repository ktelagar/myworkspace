package com.manytomanyset.test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manytomanyset.entities.Player;
import com.manytomanyset.entities.Team;
import com.manytomanyset.helper.SessionFactoryRegistry;

public class ManyToManySetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Player player1 = Player.builder().playerName("Sachin").rank(1).gender("Male").dob(LocalDate.of(1970, 2, 23))
					.nationality("Indian").build();
			
			Player player2 = Player.builder().playerName("Rahul Dravid").rank(2).gender("Male")
					.dob(LocalDate.of(1976, 3, 23)).nationality("Indian").build();
			
			Player player3 = Player.builder().playerName("Rohit").rank(3).gender("Male")
					.dob(LocalDate.of(1976, 3, 23)).nationality("Indian").build();
			
			Player player4 = Player.builder().playerName("Virat").rank(4).gender("Male")
					.dob(LocalDate.of(1976, 3, 23)).nationality("Indian").build();
			
			Team team0 = Team.builder().teamName("India Team").captain("Saurav").coach("Kapil")
					.description("Indian Team").representationCountry("India").build();
			session.save(team0);
			
			Set<Team> teamSet = Stream.of(new Team[] { team0 }).collect(Collectors.toSet());
			
			Player player5 = Player.builder().playerName("RAINA").rank(4).gender("Male")
					.dob(LocalDate.of(1976, 3, 23)).nationality("Indian").teams(teamSet).build();
			
			
			session.save(player1);
			session.save(player2);
			session.save(player3);
			session.save(player4);
			session.save(player5);
			
			Set<Player> playerSet1 = Stream.of(new Player[] { player1, player2 }).collect(Collectors.toSet());
			Set<Player> playerSet2 = Stream.of(new Player[] { player2, player3 }).collect(Collectors.toSet());
			Set<Player> playerSet3 = Stream.of(new Player[] { player3, player4 }).collect(Collectors.toSet());

		Team team1 = Team.builder().teamName("India Team").captain("Saurav").coach("Kapil")
					.description("Indian Team").representationCountry("India").players(playerSet1).build();
		
		Team team2 = Team.builder().teamName("Austi").captain("Tendulkar").coach("Ganguly")
				.description("Australia Team").representationCountry("India").players(playerSet2).build();
		
		Team team3 = Team.builder().teamName("WI Team").captain("Rohit").coach("kamble")
				.description("WI Team").representationCountry("India").players(playerSet3).build();

			session.save(team1);
			session.save(team2);
			session.save(team3);
			
			/*
			 * Team teamsaved = session.get(Team.class, 1); 
			 * System.out.println(teamsaved);
			 */

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}

	}
}
