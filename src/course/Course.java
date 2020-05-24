package course;

import java.util.ArrayList;

public class Course {
    private final String name;
    private final String code;
    private int credits;
    private String finalGrade;
    private String semester;
    private String type;
    private String state;
    /*private ArrayList<Grade> gradesArray;*/

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public Course(String name, String code, String grade, int credits, String semester, String type, String state){
        this.name = name;
        this.code = code;
        this.finalGrade = grade;
        this.credits = credits;
        this.semester = semester;
        this.type = type;
        this.state = state;
        /*this.gradesArray = new ArrayList<>(0);*/
    }

    /*public void addGrade(byte percentage, float grade){
        this.gradesArray.add(new Grade(grade, percentage));
    }*/

    public String getGrade(){
        return this.finalGrade;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
