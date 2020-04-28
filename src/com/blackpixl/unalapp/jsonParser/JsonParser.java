package com.blackpixl.unalapp.user;

import com.blackpixl.unalapp.course.Course;
import com.blackpixl.unalapp.semester.Semester;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public User(String name) {
        this.name = name;
    }

    public User(String name, ArrayList<Semester> semesters){
        this.name = name;
        this.academicHistory = semesters;
    }

    public String name;
    private ArrayList<Semester> academicHistory = new ArrayList<>();

    public void setSemesters(ArrayList<Semester> aHistory){
        this.academicHistory = aHistory;
    }

    public String getName(){
        return this.name;
    }

  