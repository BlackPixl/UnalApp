package com.blackpixl.unalapp.user;

import com.blackpixl.unalapp.course.Course;

import java.util.ArrayList;

public class AcademicHistory {
    private Double PAPA;
    private ArrayList<Course> courses;

    public Double getPAPA(){
        return this.PAPA;
    }

    public void recalculatePapa(){
        int credits = 0;
        double gradeWeighed = 0;
        int counter = 0;
        for (Course c:
             courses) {
            gradeWeighed += c.getGrade()*c.getCredits();
            credits += c.getCredits();
        }
        this.PAPA = gradeWeighed/credits;
    }

    public void printCourses(){
        for (Course c:
             courses) {
            System.out.println(
                    "\nNombre: "
                    +c.getName()
                    +"\nCódigo: "
                    +c.getCode()
                    +"\nCréditos: "
                    +c.getCredits()
                    +"\nNota: "
                    +c.getGrade()
            );
        }

    }
}
