package com.fda.secureemailservice.service.impl;
import com.fda.secureemailservice.repository.EmailRepo;
import com.fda.secureemailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepo emailRepo;
    @Override
    public ResponseEntity<Object> sendEmail(String userName) {
        return emailRepo.sendEmail(userName);
    }


}
