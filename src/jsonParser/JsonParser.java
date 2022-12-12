package jsonParser;

import course.Course;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser{

    public static void saveFile(Course[] courses){
        Gson gson = new Gson();
        String rawJson = gson.toJson(courses);
        try{
            writeFile(rawJson);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private static String readFile() throws IOException {
        return Files.readString(Paths.get(".","User.json"));
    }

    private static void writeFile(String text) throws IOException {
        PrintWriter out = new PrintWriter("UserTest.json");
        out.println(text);
        out.close();
    }

}
