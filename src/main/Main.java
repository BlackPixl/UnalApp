package main;

import java.util.Scanner;
import academicHistory.GsonProcessor;
import academicHistory.AcademicHistory;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido!\n");
        GsonProcessor academicHistoryProcessor = new GsonProcessor();
        AcademicHistory academicHistory = new AcademicHistory(academicHistoryProcessor);
        System.out.println(academicHistory.CalculatePAPA());
        //int option = input.nextInt();
        /*
        switch(option){
            case 1:
                System.out.print("Ingresa tu usuario: ");
                String user = input.next();
                System.out.print("Ingresa tu contraseña: ");
                String password = input.next();
                try{
                    Browser con  = new Browser();
                    con.login(user, password);
                    con.logout();
                }catch (IOException e){
                e.printStackTrace();
                }


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

                System.out.println("Not avaliable.");
                break;
            case 2:
                User usr = loadState();
                break;
            case 3: fetchCitation();
                break;
            case 4: fetchCourses();
                break;


        }*/
    }
/*
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

    public static void fetchCitation(){
        System.out.println("Not avaliable.");
    }

    public static void fetchCourses(){
        System.out.println("Not avaliable.");
    }*/

}
