package com.example.lg.models;

public class HostedV {

   public  long fairPerHour;
    public String vtype;
    public String brandModel;
    public String location;
  //  public String image;
    public String username;
    public  long pnumber;
    public  long seater;
   // public String fairPerHour;
   // public String pnumber;
  //  public String seater;

    public HostedV() {

    }

    public HostedV(String vtype,String brandModel,String location,long fairPerHour,long seater,String username,long pnumber) {
        this.vtype = vtype;
        this.brandModel = brandModel;
        this.location = location;
        //this.image = image;
        this.fairPerHour = fairPerHour;
        this.seater = seater;
        this.username=username;
        this.pnumber=pnumber;

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


}

