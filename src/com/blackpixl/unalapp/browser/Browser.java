package com.blackpixl.unalapp.browser;

import com.blackpixl.unalapp.course.Course;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.ArrayList;

public class Browser {

    WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
    HtmlPage mainPage;

    public Browser() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setCssEnabled(false);
    }

    public void login(String user, String password){
        HtmlPage loginPage = null;

        try {
            loginPage = webClient.getPage("http://localhost:4000/users/signin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert loginPage != null;
        HtmlForm loginForm = loginPage.getFormByName("frmLogin");
        HtmlInput userInput = loginForm.getInputByName("email");
        userInput.setValueAttribute(user);
        HtmlInput passwordInput = loginForm.getInputByName("password");
        passwordInput.setValueAttribute(password);
        //HtmlInput submit = loginForm.getInputByName("submit");
        //mainPage = submit.click();
        HtmlButton submit = loginForm.getButtonByName("submit");

        try {
            mainPage = submit.click();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Course> retrieveCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        mainPage.get
        return courses;
    }

    public void logout(){
        webClient.close();
    }
}

/*
        //HtmlPage loginPage = webClient.getPage("https://sia.unal.edu.co/ServiciosApp");
        //HtmlForm loginForm = loginPage.getFormByName("frmLogin");
        //HtmlInput userInput = loginForm.getInputByName("username");
        //userInput.setValueAttribute(user);
        //HtmlInput passwordInput = loginForm.getInputByName("password");
        //passwordInput.setValueAttribute(password);
        //HtmlInput submit = loginForm.getInputByName("submit");
        //mainPage = submit.click();

    public static void close(){
        webClient.close();
    }*/