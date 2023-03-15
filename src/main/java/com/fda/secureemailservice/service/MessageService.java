package com.fda.secureemailservice.service;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MessageService {
    List<String> getAllUserNames();
    ResponseEntity<Object>  getDetailsByUserName(String username);


}
