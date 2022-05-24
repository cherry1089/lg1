package com.example.lg.models;

import com.google.firebase.firestore.DocumentId;

public class HostedV {

   public  long fairPerHour;
    public String vtype;
    public String brandModel;
    public String location;
  //  public String image;
    public String username;
    public String rno;
    public  long pnumber;
    public  long seater;
    public  String mail;
   // public String fairPerHour;
   // public String pnumber;
  //  public String seater;
    public String sdate;
    public String edate;
    public String renter;



    public HostedV() {

    }

    public HostedV(long fairPerHour,String vtype,String brandModel,String location,String username,String rno,long pnumber,long seater,String mail,String sdate,String edate,String renter) {
        this.fairPerHour = fairPerHour;
        this.vtype = vtype;
        this.brandModel = brandModel;
        this.location = location;
        this.username = username;
        this.rno = rno;
        this.pnumber = pnumber;
        this.seater = seater;
        this.mail = mail;
        this.sdate = sdate;
        this.edate = edate;
        this.renter = renter;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }*/

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public long getFairPerHour() {
        return fairPerHour;
    }

    public void setFairPerHour(long fairPerHour) {
        this.fairPerHour = fairPerHour;
    }

    public long getPnumber() {
        return pnumber;
    }

    public void setPnumber(long pnumber) {
        this.pnumber = pnumber;
    }

    public long getSeater() {
        return seater;
    }

    public void setSeater(long seater) {
        this.seater = seater;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
}

