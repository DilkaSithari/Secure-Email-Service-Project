package com.fda.secureemailservice.service.impl;

import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.repository.UserBranchRepo;
import com.fda.secureemailservice.service.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserBranchServiceImpl implements UserBranchService {

    @Autowired
    private UserBranchRepo userBranchRepo;

    @Override
    public ResponseEntity<Object> findAll(UserBranch userBranch) {
        return userBranchRepo.findAll(userBranch);
    }

    @Override
    public ResponseEntity<Object> findByUserName(String userName) {
        return userBranchRepo.findByUserName(userName);
    }

    @Override
    public ResponseEntity<Object> updateUserBranch(String userName, UserBranch userBranch) {
        return userBranchRepo.updateUserBranch(userName,userBranch);
    }

    @Override
    public ResponseEntity<Object> addUserBranch(UserBranch userBranch) {
        return userBranchRepo.addUserBranch(userBranch);

    }

    @Override
    public ResponseEntity<Object> deleteUserBranch(String userName) {
        return userBranchRepo.deleteUserBranch(userName);
    }
}
