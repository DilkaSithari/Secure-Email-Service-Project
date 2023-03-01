package com.fda.secureemailservice.service;

import com.fda.secureemailservice.model.UserBranch;

import java.util.List;

public interface UserBranchService {

    List<UserBranch> findAll();
    List<UserBranch> findByUserName(String userName);
    int updateUserBranch(String userName, UserBranch userBranch);

    void addUserBranch(UserBranch userBranch);
    int deleteUserBranch(String userName);


}
