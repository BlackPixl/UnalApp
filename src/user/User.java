package user;

import course.CurrentCourse;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private final String name;
    private final AcademicHistory academicHistory;
    private final ArrayList<CurrentCourse> currentCourses;

    public User(String name) {
        this.name = name;
        this.academicHistory = new AcademicHistory();
        this.currentCourses = null;
    }

    public User(String name, AcademicHistory ah){
        this.name = name;
        this.academicHistory = ah;
        this.currentCourses = null;
    }

    public User(String name, AcademicHistory ah, ArrayList<CurrentCourse> cc){
        this.name = name;
        this.academicHistory = ah;
        this.currentCourses = cc;
    }

    public String getName(){
        return this.name;
    }

    public AcademicHistory getAcademicHistory(){
        return this.academicHistory;
    }

}
