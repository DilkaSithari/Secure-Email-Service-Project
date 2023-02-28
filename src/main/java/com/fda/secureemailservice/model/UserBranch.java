package com.fda.secureemailservice.model;

public class UserBranch {
    private String userName;
    private int branchCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "UserBranch{" +
                "userName='" + userName + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }
}
