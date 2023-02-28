package com.fda.secureemailservice.service.impl;

import com.fda.secureemailservice.repository.MessageRepository;
import com.fda.secureemailservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<String> getAllUserNames() {
        return messageRepository.getAllUserNames();
    }

    @Override
    public String getEmailByUserName(String username) {
        return messageRepository.getEmailByUserName(username);
    }
}
