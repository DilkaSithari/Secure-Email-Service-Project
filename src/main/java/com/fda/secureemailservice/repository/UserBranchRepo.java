package com.fda.secureemailservice.repository;

import com.fda.secureemailservice.model.UserBranch;

import java.util.List;

public interface UserBranchRepo {
    List<UserBranch> findAll();
    int addUserBranch(UserBranch userBranch);
    List<UserBranch> findByUserName(String userName);
    int deleteUserBranch(String userName);
    int updateUserBranch(String userName, UserBranch userBranch);
}
