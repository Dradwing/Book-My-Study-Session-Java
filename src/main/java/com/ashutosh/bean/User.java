package com.ashutosh.bean;

public class User {


    public class Role {
        public static final String Admin = "Admin";
        public static final String Tutor = "Tutor";
        public static final String Student = "Student";
    }

    private int userId;
    private String userName;
    private String password;
    private String emailId;
    private String phoneNumber;
    private String role;



    public int getUserId() {
        return userId;
    }
   public String getUserName(){
       return userName;
   }

   public String getEmailId(){
       return emailId;
   }

   public String getRole(){
       return role;
   }

   public String getPassword(){
       return password;
   }

   public String getPhoneNumber(){
       return phoneNumber;
   }

   public void setUserName(String userName){
       this.userName = userName;
   }

   public void setEmailId(String emailId){
       this.emailId = emailId;
   }

   public void setRole(String role){
       this.role=role;
   }

   public void setPassword(String password){
       this.password=password;
   }

   public void setPhoneNumber(String phoneNumber){
       this.phoneNumber=phoneNumber;
   }

   public void setUserId(int userId){
       this.userId=userId;
   }
}
