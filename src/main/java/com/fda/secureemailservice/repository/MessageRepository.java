package com.fda.secureemailservice.repository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageRepository {

    List<String> getAllUserNames();

    ResponseEntity<Object> getDetailsByUserName(String userName);


}
