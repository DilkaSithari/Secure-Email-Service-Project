package com.fda.secureemailservice.repository.impl;
import com.fda.secureemailservice.model.BranchDetail;
import com.fda.secureemailservice.model.EmailDetails;
import com.fda.secureemailservice.model.Msg;
import com.fda.secureemailservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.host}")
    String mailHost;

    @Value("${spring.mail.port}")
    String mailPort;

    @Value("${spring.mail.username}")
    String mailUsername;

    @Value("${spring.mail.password}")
    String mailPassword;


    public ResponseEntity<Object> getDetailsByUserName(String userName) {
       List<EmailDetails> emailDetailByUserName = new ArrayList<>();
        String sql="SELECT tm.user_name, tbd.branch_email,tm.message,tm.subject FROM tbl_branch_detail tbd JOIN tbl_user_branch tub JOIN tbl_msg tm  ON tbd.branch_code=tub.branch_code where tub.user_name= ?; ";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            ResultSet rs= pstmt.executeQuery();
            while(rs.next()) {
               EmailDetails emailDetails = new EmailDetails();
               emailDetails.setUserName(rs.getString("user_name"));
               emailDetails.setBranchEmail(rs.getString("branch_email"));
               emailDetails.setSubject(rs.getString("subject"));
                emailDetails.setMsg(rs.getString("message"));
                emailDetailByUserName.add(emailDetails);

                String from = mailUsername;
                String to = emailDetails.getBranchEmail() ;

                SimpleMailMessage message = new SimpleMailMessage();

                message.setFrom(from);
                message.setTo(to);
                message.setSubject(emailDetails.getSubject());
                message.setText(emailDetails.getMsg());
                mailSender.send(message);

            }pstmt.executeQuery();

        }catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(emailDetailByUserName,HttpStatus.OK);




    }




}
