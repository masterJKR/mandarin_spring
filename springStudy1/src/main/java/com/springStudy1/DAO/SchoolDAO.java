package com.springStudy1.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class SchoolDAO {
	private final JdbcTemplate jdbc;
	
	@Autowired
	public SchoolDAO( JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
}
