package academicHistory;

import course.Course;

public class AcademicHistory {

    Course[] courses;
    public AcademicHistory(AcademicHistoryProcessor processor) {
        courses = processor.Load();
    }

    public float CalculatePAPA(){
        float gradeWeighed = 0;
        int credits = 0;
        for (Course course:
             this.courses) {
            System.out.println(course.getGrade());
            System.out.println(course.getCredits());
            gradeWeighed += Float.parseFloat(course.getGrade())*course.getCredits();
            credits += course.getCredits();
        }
        return gradeWeighed/credits;
    }

}
