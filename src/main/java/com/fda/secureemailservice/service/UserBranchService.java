package com.fda.secureemailservice.service;

import com.fda.secureemailservice.model.UserBranch;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserBranchService {

    ResponseEntity<Object> findAll(UserBranch userBranch);

    ResponseEntity<Object> findByUserName(String userName);
    ResponseEntity<Object> updateUserBranch(String userName, UserBranch userBranch);

    ResponseEntity<Object> addUserBranch(UserBranch userBranch);
    ResponseEntity<Object> deleteUserBranch(String userName);


}
