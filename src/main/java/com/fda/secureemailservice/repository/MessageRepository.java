package com.fda.secureemailservice.repository;

import java.util.List;

public interface MessageRepository {

    List<String> getAllUserNames();

    String getEmailByUserName(String username);
}
