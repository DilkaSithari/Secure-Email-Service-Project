package com.fda.secureemailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class SecureEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureEmailServiceApplication.class, args);
		System.out.println("*********************START*********************");
	}

}
