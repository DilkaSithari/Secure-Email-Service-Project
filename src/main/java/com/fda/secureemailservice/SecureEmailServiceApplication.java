package com.fda.secureemailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class SecureEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureEmailServiceApplication.class, args);
		System.out.println("*********************START*********************");
	}

//	@Bean
//	public JavaMailSender javaMailSender(){
//		return new JavaMailSenderImpl();
//	}



}
