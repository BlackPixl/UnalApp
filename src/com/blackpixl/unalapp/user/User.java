package com.blackpixl.unalapp.user;

import com.blackpixl.unalapp.course.Course;
import com.blackpixl.unalapp.semester.Semester;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public User(String name) {
        this.name = name;
    }


    private String name;
    private AcademicHistory academicHistory;

    public String getName(){
        return this.name;
    }

    public AcademicHistory getAcademicHistory(){
        return this.academicHistory;
    }

}
