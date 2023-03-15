package com.fda.secureemailservice.repository;

import org.springframework.http.ResponseEntity;

public interface EmailRepo {

ResponseEntity<Object> sendEmail(String userName);

}
