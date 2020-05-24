package jsonParser;

import user.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser{

    public static User load(){
        String raw = "";
        try {
            raw = readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(raw, User.class);
    }

    public static void saveFile(User user){
        Gson gson = new Gson();
        String rawJson = gson.toJson(user);
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
