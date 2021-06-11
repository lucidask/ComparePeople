package com.example.r_course;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;

public class Person <Person> {
    private String fname;
    private String lname;
    private String yob;
    private String sex;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String inf= getFname().concat(" "+getLname()).concat(" "+getYob()).concat(" "+getSex()+'\n');
        return inf;
    }

    public Person(String finame, String laname, String year, String s ){
        fname=finame;
        lname=laname;
        yob=year;
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
}
