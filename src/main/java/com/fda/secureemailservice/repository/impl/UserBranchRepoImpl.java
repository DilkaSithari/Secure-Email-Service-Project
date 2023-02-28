package com.fda.secureemailservice.repository.impl;

import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.model.model_mapper.UserBranchMapper;
import com.fda.secureemailservice.repository.UserBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserBranchRepoImpl implements UserBranchRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<UserBranch> findAll() {
        String sql= "SELECT * FROM tbl_user_branch;";
        return jdbcTemplate.query(sql,new UserBranchMapper());
    }

    @Override
    public int addUserBranch(UserBranch userBranch) {
        String sql="INSERT into tbl_user_branch(user_name,branch_code) VALUES (?,?);";
        return jdbcTemplate.update(sql,
                userBranch.getUserName(),
                userBranch.getBranchCode());
    }

    @Override
    public List<UserBranch> findByUserName(String userName) {
        String sql="SELECT * FROM tbl_user_branch where user_name=?;";
        return jdbcTemplate.query(sql,new UserBranchMapper(),userName);
    }

    @Override
    public int deleteUserBranch(String userName) {
        String sql= "delete from tbl_user_branch where  user_name = ?;";
        return jdbcTemplate.update(sql,userName);
    }

    @Override
    public int updateUserBranch(String userName, UserBranch userBranch) {
        String sql="Update tbl_user_branch set  user_name=?, branch_code=? where user_name=?;";
        return jdbcTemplate.update(sql,
                userBranch.getUserName(),
                userBranch.getBranchCode(),userName);
    }
}
