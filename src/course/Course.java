package course;

import java.util.ArrayList;

public class Course {
    private int credits;
    private final String name;
    private final String code;
    private float grade;
    private ArrayList<Grade> gradesArray;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public Course(String name, String code, float grade, int credits){
        this.name = name;
        this.code = code;
        this.grade = grade;
        this.credits = credits;
        this.gradesArray = new ArrayList<>(0);
    }


    public void addGrade(byte percentage, float grade){
        this.gradesArray.add(new Grade(grade, percentage));
    }

    public float getGrade(){
        return this.grade;
    }

    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }

    public int getCredits(){
        return this.credits;
    }
}
