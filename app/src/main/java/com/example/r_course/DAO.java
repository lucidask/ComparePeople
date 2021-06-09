package com.example.r_course;

import java.util.ArrayList;
import java.util.Date;

public class DAO {
    static ArrayList<Person> tabperson= new ArrayList<>();
    public static void addperson(String ln, String fn, String y,int s,String sex){
        tabperson.add(new Person (ln,fn,y,s,sex));
    }
}
