package com.fda.secureemailservice.repository.impl;
import com.fda.secureemailservice.model.BranchDetail;
import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.repository.MessageRepository;
import com.fda.secureemailservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String dbUrl = "jdbc:mysql://localhost:3306/fda_message";
    String user ="root";
    String password ="admin";



    public List<String> getAllUserNames() {
        return new ArrayList<>(jdbcTemplate.queryForList("SELECT user_name FROM tbl_msg", String.class));
    }


    public String getEmailByUserName(String userName) {
  String email = null;
        String sql="SELECT branch_email FROM tbl_branch_detail tbd JOIN tbl_user_branch tub ON tbd.branch_code=tub.branch_code where tub.user_name= ?; ";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            ResultSet rs= pstmt.executeQuery();
            while(rs.next()) {
                BranchDetail branchDetail = new BranchDetail();
                email= branchDetail.setBranchEmail(rs.getString("branch_email"));

            }pstmt.executeQuery();

        }catch (Exception e){
            System.out.println(e);
        }


        return email;
    }
}
