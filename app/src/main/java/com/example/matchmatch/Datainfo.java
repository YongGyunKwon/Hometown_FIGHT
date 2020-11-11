package com.example.matchmatch;

public class Datainfo {
    //int month;
    //int day;
    String titletext;//제목
    String md;// 월,일
    String hm; //시간,분
    String state; //장소

    public Datainfo(){

    }

    public Datainfo(String titletext, String md, String hm, String state) {
        // TODO Auto-generated constructor stub
        //생성자함수로 전달받은 Member의 정보를 멤버변수에 저장
        this.titletext = titletext;
        this.md = md;
        this.hm = hm;
        this.state = state;
    }

    public void setTitletext(String titletext) {
        this.titletext = titletext;
    }
    public void setMd(String md) {
        this.md = md;
    }
    public void setHm(String hm) {
        this.hm = hm;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getTitletext()
    {
        return titletext;
    }
    public String getMd() {
        return md;
    }
    public String getHm() {
        return hm;
    }
    public String getState() {
        return state;
    }



}
