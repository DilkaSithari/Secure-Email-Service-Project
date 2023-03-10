package com.fda.secureemailservice.repository;
import com.fda.secureemailservice.model.UserBranch;
import org.springframework.http.ResponseEntity;

public interface UserBranchRepo {
    ResponseEntity<Object> findAll(UserBranch userBranch) ;
    ResponseEntity<Object> addUserBranch(UserBranch userBranch);
    ResponseEntity<Object> findByUserName(String userName);
    ResponseEntity<Object> deleteUserBranch(String userName);
    ResponseEntity<Object> updateUserBranch(String userName, UserBranch userBranch);
}
