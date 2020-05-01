package com.blackpixl.unalapp.main;

import com.blackpixl.unalapp.jsonParser.JsonParser;
import com.blackpixl.unalapp.user.User;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("[1]. Login." +
                "\n[2]. Cargar historia académica." +
                "\n[3]. Consultar citación." +
                "\n[4]. Consultar horario."
        );
        int option = input.nextInt();
        switch(option){
            case 1:login();
                break;
            case 2:/*try{
                loadState(input);
                }catch(IOException e){
                System.out.println(e.getMessage());
                }*/
                break;
            case 3:queryCitation();
                break;
            case 4:querySchedule();
                break;
        }
    }

    public static void login(){
        System.out.println("Funcionalidad bajo construcción");
    }
/*
    public static void loadState(@NotNull Scanner input)throws IOException{
        System.out.println("Ingresa el nombre del archivo: ");
        String filename = input.next();
        User user = JsonParser.load(filename);
        System.out.println(user.getName());
        System.out.println(user.getAcademicHistory().getPAPA());
        user.getAcademicHistory().recalculatePapa();
        System.out.println(user.getAcademicHistory().getPAPA());
        System.out.printf("%.1f", user.getAcademicHistory().getPAPA());
        user.getAcademicHistory().printCourses();
    }*/

    public static void queryCitation(){
        System.out.println("Funcionalidad bajo construcción");
    }

    public static void querySchedule(){
        System.out.println("Funcionalidad bajo construcción");
    }
}
