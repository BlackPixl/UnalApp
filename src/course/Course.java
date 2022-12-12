package course;

import java.util.ArrayList;

public class Course {
    private final String name;
    private final String code;
    private int credits;
    private String grade;
    private String semester;
    private String type;
    private String state;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(String name, String code, String grade, String credits) {
        this.name = name;
        this.code = code;
        this.grade = grade;
        this.credits = Integer.parseInt(credits);
    }

    public Course(String name, String code, String grade){
        this.name = name;
        this.code = code;
        this.grade = grade;
    }

    public Course(String name, String code, String grade, int credits, String semester, String type, String state){
        this.name = name;
        this.code = code;
        this.grade = grade;
        this.credits = credits;
        this.semester = semester;
        this.type = type;
        this.state = state;
    }

    public String getGrade(){
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
