package user;

import course.Course;

import java.util.ArrayList;

public class AcademicHistory {

    private Double PAPA;
    final private ArrayList<Course> courses;

    public AcademicHistory(ArrayList<Course> courses){
        this.courses = courses;
        int credits = 0;
        double gradeWeighed = 0;

        for (Course c:
             courses) {
            if (!(c.getGrade().equals("Error"))){
                gradeWeighed += Float.parseFloat(c.getGrade())*c.getCredits();
                credits += c.getCredits();
            }
        }

        this.PAPA = gradeWeighed/credits;
    }

    public Double getPAPA(){
        return this.PAPA;
    }

    public void recalculatePapa(){
        /*int credits = 0;
        double gradeWeighed = 0;
        int counter = 0;
        for (Course c:
             courses) {
            gradeWeighed += c.getGrade()*c.getCredits();
            credits += c.getCredits();
        }*/
        this.PAPA = 3.0;
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
