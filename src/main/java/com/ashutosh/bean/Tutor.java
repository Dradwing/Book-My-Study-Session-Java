package com.ashutosh.bean;

import java.util.List;

public class Tutor extends User {

    private int tutorId;
    private List<String> education;
    private String aadharCardNumber;
    private String imageURL;

    public int getTutorId() {
        return tutorId;
    }

    public List<String> getEducation() {
        return education;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

}
