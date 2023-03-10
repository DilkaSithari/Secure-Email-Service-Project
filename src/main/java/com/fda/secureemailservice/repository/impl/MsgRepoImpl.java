package com.fda.secureemailservice.repository.impl;

import com.fda.secureemailservice.model.Msg;
import com.fda.secureemailservice.repository.MsgRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MsgRepoImpl implements MsgRepo {
    String dbUrl = "jdbc:mysql://localhost:3306/fda_message";
    String user ="root";
    String password ="admin";

    @Override
    public ResponseEntity<Object> findAll(Msg msg) {
        List<Msg> msgList = new ArrayList<>();
        String sql= "SELECT * FROM tbl_msg;";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                msg.setId(rs.getInt("id"));
                msg.setSubject(rs.getString("subject"));
                msg.setMessage(rs.getString("message"));
                msg.setUserName(rs.getString("user_name"));
                msg.setStatus(rs.getInt("status"));
                msg.setTime(rs.getString("time"));
                msgList.add(msg);
            }
            pstmt.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(msgList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateMsg(int id, Msg msg) {
        return null;
    }

    @Override
    public ResponseEntity<Object> addMsg(Msg msg) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteMsg(int id) {
        return null;
    }
}
