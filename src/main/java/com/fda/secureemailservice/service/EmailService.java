package com.fda.secureemailservice.service;

import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<Object> sendEmail(String userName);
}
