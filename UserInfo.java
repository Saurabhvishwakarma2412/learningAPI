package com.acciojob.fristApi;

public class UserInfo {
    private String name;
    private int age;
    private String emailID;
    private int userID;
     public UserInfo(String name,int age,String emailID,int userID){
         this.name=name;
         this.age=age;
         this.emailID=emailID;
         this.userID=userID;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
