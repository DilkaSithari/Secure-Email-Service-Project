package com.fda.secureemailservice.model;

import lombok.Data;

@Data
public class Msg {
    private int id;
    private String subject;
    private String message;
    private String userName;
    private int status;
    private String time;


}
