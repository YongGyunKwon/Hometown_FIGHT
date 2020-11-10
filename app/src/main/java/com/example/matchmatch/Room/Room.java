package com.example.matchmatch.Room;

public class Room {

    private String subject;
    private String date;
    private String time;
    private String location;
    private String latitude;
    private String longitude;
    private String homenumber;
    private String awaynumber;

    public Room() {

    }

    public Room(String subject, String date, String time, String location,String latitude,String longitude,String homenumber,String awaynumber) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.location = location;
        this.latitude = latitude;
        this.longitude= longitude;
        this.homenumber=homenumber;
        this.awaynumber=awaynumber;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date=date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time=time;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location=location;
    }

    public String getLatitude(){return latitude;}

    public void setLatitude(String latitude){this.latitude=latitude;}

    public String getLongitude(){return longitude;}

    public void setLongitude(String longitude){this.longitude=longitude;}

    public String getHomenumber(){return homenumber;}

    public void setHomenumber(String homenumber){this.homenumber=homenumber;}

    public String getAwaynumber(){return awaynumber;}

    public void setAwaynumber(String awaynumber){ this.awaynumber=awaynumber;}


}
