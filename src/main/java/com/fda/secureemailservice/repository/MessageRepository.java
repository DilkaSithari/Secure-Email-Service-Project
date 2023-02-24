package com.fda.secureemailservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<String> getAllUserNames() {
        List<String> usernameList =new ArrayList<>();
        usernameList.addAll(jdbcTemplate.queryForList("SELECT user_name FROM tbl_msg;",String.class));
        return usernameList;
    }


    public String getEmailByUserName() {

       String sql = "SELECT tbl_branch_detail.branch_email FROM tbl_branch_detail, tbl_msg where tbl_msg.user_name = \"Dilka\";  ";


        String email = (String) jdbcTemplate.queryForObject(sql, String.class);
        return email;
    }
}
