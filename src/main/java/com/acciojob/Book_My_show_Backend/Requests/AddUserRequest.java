package com.acciojob.Book_My_show_Backend.Requests;


public class AddUserRequest {
    private String name;

    private Integer age;

    private String emailId;

    private String mobileNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobNo(String mobNo) {
        this.mobileNo = mobNo;
    }
}
