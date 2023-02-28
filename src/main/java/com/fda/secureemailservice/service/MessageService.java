package com.fda.secureemailservice.service;


import java.util.List;

public interface MessageService {
    List<String> getAllUserNames();
    String getEmailByUserName(String username);
}
