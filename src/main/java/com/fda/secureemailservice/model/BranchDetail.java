package com.fda.secureemailservice.model;

import lombok.Data;

@Data
public class BranchDetail {
    private  int branchCode;
    private String branchName;
    public String branchEmail;

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchEmail() {
        return branchEmail;
    }

    public String setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
        return branchEmail;
    }


}
