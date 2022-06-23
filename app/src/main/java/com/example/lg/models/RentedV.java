package com.example.lg.models;
public class RentedV {
    public  long fairPerHour;
    public String vtype;
    public String brandModel;
    public String location;
    public String username;
    public String rno;
    public  long pnumber;
    public  long seater;
    public String mail;
    public String sdate;
    public String  edate;
    public RentedV() {
    }
    public RentedV(long fairPerHour,String vtype,String brandModel,String location,String username,String rno,long pnumber,long seater,String mail,String sdate,String edate) {
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
    }
    public long getFairPerHour() {
        return fairPerHour;
    }
    public void setFairPerHour(long fairPerHour) {
        this.fairPerHour = fairPerHour;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRno() {
        return rno;
    }
    public void setRno(String rno) {
        this.rno = rno;
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
}
