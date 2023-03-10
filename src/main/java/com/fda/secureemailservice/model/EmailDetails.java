package com.fda.secureemailservice.model;

import lombok.Data;

@Data
public class EmailDetails {
    private String branchEmail;
    private String userName;
    private String subject;
    private  String msg;
}
