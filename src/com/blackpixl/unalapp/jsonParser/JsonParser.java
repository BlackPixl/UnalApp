package com.blackpixl.unalapp.jsonParser;

import com.blackpixl.unalapp.user.User;
import com.google.gson.Gson;
import java.io.IOException;
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

    private static String readFile() throws IOException {
        return Files.readString(Paths.get(".","User.json"));
    }

}
