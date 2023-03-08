package com.fda.secureemailservice.repository.impl;

import com.fda.secureemailservice.model.SecureEmailResponse;
import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.repository.UserBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserBranchRepoImpl implements UserBranchRepo {

    String dbUrl = "jdbc:mysql://localhost:3306/fda_message";
    String user ="root";
    String password ="admin";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public ResponseEntity<Object> findAll(UserBranch userBranch) {
        List<UserBranch> userBranchList=new ArrayList<>();
        String sql="SELECT * FROM tbl_user_branch;";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next())
            {
                userBranch.setUserName(rs.getString("user_name"));
                userBranch.setBranchCode(rs.getInt("branch_code"));
                userBranchList.add(userBranch);
            }
            pstmt.executeQuery();

        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(userBranchList, HttpStatus.OK) ;


    }

    @Override
    public ResponseEntity<Object> addUserBranch(UserBranch userBranch) {
        SecureEmailResponse secureEmailResponse=new SecureEmailResponse();
        String sql="INSERT into tbl_user_branch(user_name,branch_code) VALUES (?,?)";
        try(Connection conn= DriverManager.getConnection(dbUrl,user,password);) {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userBranch.getUserName());
            pstmt.setInt(2,userBranch.getBranchCode());
            pstmt.executeUpdate();
            secureEmailResponse.setStatus("200");
            secureEmailResponse.setMessage("Response successful");
            return new  ResponseEntity<>(secureEmailResponse, HttpStatus.OK);
            //conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            secureEmailResponse.setStatus("500");
            secureEmailResponse.setMessage("User name already exist");
            return new ResponseEntity<>(secureEmailResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResponseEntity<Object> findByUserName(String userName) {
      List<UserBranch>userBranchList=new ArrayList<>();
        String sql="SELECT * FROM tbl_user_branch where user_name=?";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userName);
             ResultSet rs= pstmt.executeQuery();
             while (rs.next())
             {
                 UserBranch userBranch=new UserBranch();
                 userBranch.setUserName(rs.getString("user_name"));
                userBranch.setBranchCode(rs.getInt("branch_code"));
                userBranchList.add(userBranch);
             }
            pstmt.executeQuery();

        }catch (Exception e){
          System.out.println(e);
        }
       return new ResponseEntity<>(userBranchList,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> deleteUserBranch(String userName) {
        SecureEmailResponse secureEmailResponse = new SecureEmailResponse();
        String sql="delete from tbl_user_branch where  user_name = ?;";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            secureEmailResponse.setStatus("200");
            secureEmailResponse.setMessage("user branch deleted successfully");
            pstmt.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(secureEmailResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateUserBranch(String userName, UserBranch userBranch) {
        SecureEmailResponse secureEmailResponse = new SecureEmailResponse();
        String sql="Update tbl_user_branch set  user_name=?, branch_code=? where user_name=?;";
        try(Connection conn = DriverManager.getConnection(dbUrl,user,password)){
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userBranch.getUserName());
            pstmt.setInt(2,userBranch.getBranchCode());
            pstmt.setString(3,userName);
            secureEmailResponse.setStatus("200");
            secureEmailResponse.setMessage("user branch updated successfully");
            pstmt.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(secureEmailResponse,HttpStatus.OK);
    }
}
