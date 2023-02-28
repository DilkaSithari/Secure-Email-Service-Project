package com.fda.secureemailservice.model;

public class BranchDetail {
    private  int branchCode;
    private String branchName;
    private String branchEmail;

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

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
    }

    @Override
    public String toString() {
        return "BranchDetail{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                ", branchEmail='" + branchEmail + '\'' +
                '}';
    }
}
