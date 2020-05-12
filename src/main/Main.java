package main;

import browser.Browser;
import jsonParser.JsonParser;
import user.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("usuario");
        String user = input.next();
        System.out.println("contraseña");
        String password = input.next();
        Browser con  = new Browser();
        try {
            con.login(user, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.logout();
        /*System.out.println("[1]. Login." +
                "\n[2]. Cargar historia académica." +
                "\n[3]. Consultar citación." +
                "\n[4]. Consultar horario."
        );
        int option = input.nextInt();
        switch(option){
            case 1:try{
                login(input);
                }catch (IOException e){
                e.printStackTrace();
                }
                break;
            case 2: loadState();
            case 3:queryCitation();
                break;
            case 4:querySchedule();
                break;
        }*/
    }
/*
    public static void login(Scanner input) throws IOException {
        System.out.print("Ingresa tu usuario: ");
        String user = input.next();
        System.out.print("Ingresa tu contraseña: ");
        String password = input.next();
        Connection connection = new Connection(user, password);
        //System.out.println(connection.getMainPage());
        Connection.close();
    }
*/
    public static void loadState(){
        User user = JsonParser.load();
        System.out.println(user.getName());
        System.out.println(user.getAcademicHistory().getPAPA());
        user.getAcademicHistory().recalculatePapa();
        System.out.println(user.getAcademicHistory().getPAPA());
        System.out.printf("%.1f", user.getAcademicHistory().getPAPA());
        user.getAcademicHistory().printCourses();
    }

    public static void queryCitation(){
        System.out.println("Funcionalidad bajo construcción");
    }

    public static void querySchedule(){
        System.out.println("Funcionalidad bajo construcción");
    }

    public static void printOptions(){

    }
}
