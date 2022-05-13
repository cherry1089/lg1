package com.example.lg;

public class userHelper {
    String fullName,phoneNo,mail,adhaar,pan,gender,location,dob;

    public userHelper(String fullname, String adhaar, String paan, String loca, String gender, String date, String mail) {
    }

    public userHelper(String fullName, String phoneNo, String mail, String adhaar, String pan, String gender, String location, String dob) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.mail = mail;
        this.adhaar = adhaar;
        this.pan = pan;
        this.gender = gender;
        this.location = location;
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
