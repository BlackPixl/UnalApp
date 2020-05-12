package course;

import java.util.ArrayList;

public class Course {

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

    private int credits;
    private String name;
    private String code;
    private float grade;
    private ArrayList<CourseGrade> gradesArray;

    private void calculateGrade(){
        this.grade = 0;
        for (CourseGrade i:
             gradesArray) {
            this.grade += i.getWeighedGrade();
        }
    }

    public void addGrade(byte percentage, float grade){
        this.gradesArray.add(new CourseGrade(grade, percentage));
    }

    public void addGrade(byte percentage){
        this.gradesArray.add(new CourseGrade(percentage));
    }

    public void setGrade(byte index, float grade){
        byte percentage = this.gradesArray.get(index).getPercentage();
        this.gradesArray.set(index, new CourseGrade(grade, percentage));
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
