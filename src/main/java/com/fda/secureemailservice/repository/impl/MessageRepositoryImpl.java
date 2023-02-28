package com.fda.secureemailservice.repository.impl;
import com.fda.secureemailservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<String> getAllUserNames() {
        return new ArrayList<>(jdbcTemplate.queryForList("SELECT user_name FROM tbl_msg", String.class));
    }


    public String getEmailByUserName(String username) {
       String sql = "SELECT branch_email FROM tbl_branch_detail tbd JOIN tbl_user_branch tub ON tbd.branch_code=tub.branch_code where tub.user_name= ?;  ";
       return jdbcTemplate.queryForObject(sql, String.class,username);

    }
}
