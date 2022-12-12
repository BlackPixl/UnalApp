package academicHistory;

import com.google.gson.Gson;
import course.Course;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GsonProcessor implements AcademicHistoryProcessor{

    private final Gson gson;
    public GsonProcessor(){
        this.gson = new Gson();
    }

    public Course[] Load(){
        String raw = null;
        try {
            raw = Files.readString(Paths.get(".","Test.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gson.fromJson(raw, Course[].class);
    }

    /*
    public void saveToFile(ArrayList<Course> courses){
        // TODO: Finish writing this method.
        System.out.println("Saved (Testing)");
    }*/

}
