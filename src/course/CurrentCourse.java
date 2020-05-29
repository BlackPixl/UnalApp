package course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CurrentCourse extends Course{
    public CurrentCourse(String name, String code, String grade){
        super(name, code, grade);
        this.grades = null;

    }

    ArrayList<Grade> grades;
    //ArrayList<Schedule> schedules;

    public CurrentCourse(){
        super("N/A","N/A");
    }

}
