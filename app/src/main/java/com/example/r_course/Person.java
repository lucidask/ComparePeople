package com.example.r_course;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Person <Person> {
    private String fname;
    private String lname;
    private String yob;
    private int size;
    private String sex;

    public String getFname() { return fname; }

    public void setFname(String fname) { this.fname = fname; }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String inf= "Name: "+getFname().concat(" "+getLname()).concat("\nYOB: "+getYob()).concat(" \nSize: "+getSize()).concat(" cm \nSex: "+getSex()+'\n');
        return inf;
    }

    public Person(String finame, String laname, String year,int siz, String s ){
        fname=finame;
        lname=laname;
        yob=year;
        size=siz;
        sex=s;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String agecompare(com.example.r_course.Person PersAnt){
        int yearnow=java.time.LocalDate.now().getYear();
        if((yearnow-Integer.parseInt(this.getYob()))<(yearnow-Integer.parseInt(PersAnt.getYob()))){
            return PersAnt.getFname()+" "+PersAnt.getLname()+" is older than "+
                    this.getFname()+" "+this.getLname();
        }
        else if((yearnow-Integer.parseInt(this.getYob()))>(yearnow-Integer.parseInt(PersAnt.getYob()))) {
            return this.getFname()+" "+this.getLname()+" is older than "+
                    PersAnt.getFname()+" "+PersAnt.getLname();
        }
        else {
            return "They have the same age ";
        }
    }

    public String sizecompare(com.example.r_course.Person PersAnt){
        if((this.getSize())<(PersAnt.getSize())){
            return PersAnt.getFname()+" "+PersAnt.getLname()+" is higher than "+
                    this.getFname()+" "+this.getLname();
        }
        else if((this.getSize())>(PersAnt.getSize())) {
            return this.getFname()+" "+this.getLname()+" is higher than "+
                    PersAnt.getFname()+" "+PersAnt.getLname();
        }
        else {
            return "They have the same size ";
        }
    }
}
