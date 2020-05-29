package main;

import browser.Browser;
import course.CurrentCourse;
import jsonParser.JsonParser;
import user.AcademicHistory;
import user.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido!\n");
        System.out.println("[1]. Login." +
                "\n[2]. Cargar historia académica." +
                "\n[3]. Consultar citación." +
                "\n[4]. Buscador de Cursos."
        );

        int option = input.nextInt();
        switch(option){
            case 1:
                /*System.out.print("Ingresa tu usuario: ");
                String user = input.next();
                System.out.print("Ingresa tu contraseña: ");
                String password = input.next();
                try{
                    Browser con  = new Browser();
                    con.login(user, password);
                    con.logout();
                }catch (IOException e){
                e.printStackTrace();
                }*/

                Browser con = new Browser();
                AcademicHistory ah = null;

                try{
                    ah = con.retrieveAcademicHistory();
                } catch (IOException e){
                    e.printStackTrace();
                }

                ArrayList<CurrentCourse> cc = null;

                try{
                    cc = con.retrieveCurrentCourses();
                } catch (IOException e){
                    e.printStackTrace();
                }

                User user = new User("testName", ah, cc);
                JsonParser.saveFile(user);

                break;
            case 2:
                User usr = loadState();
                break;
            case 3:queryCitation();
                break;
            case 4:queryCourses();
                break;
        }
    }

    public static User loadState(){
        User user = JsonParser.load();
        System.out.println(user.getName());
        System.out.println(user.getAcademicHistory().getPAPA());
        //user.getAcademicHistory().recalculatePapa();
        System.out.println(user.getAcademicHistory().getPAPA());
        System.out.printf("%.1f", user.getAcademicHistory().getPAPA());
        user.getAcademicHistory().printCourses();
        return user;
    }

    public static void queryCitation(){
        System.out.println("Funcionalidad bajo construcción");
    }

    public static void queryCourses(){
        System.out.println("Funcionalidad bajo construcción");
    }

}
