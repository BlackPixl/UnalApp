package browser;

import course.Course;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void login(String user, String password) throws IOException{
        HtmlPage loginPage = null;

        try {
            loginPage = webClient.getPage("https://sia.unal.edu.co/ServiciosApp/");
            System.out.println("\n*******************************\nloading LoginPage");
            webClient.waitForBackgroundJavaScript(5000);
            System.out.println("\n*******************************\nloaded LoginPage:\n*******************************\n");
            System.out.println(loginPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert loginPage != null;
        HtmlForm loginForm = loginPage.getFormByName("frmLogin");
        HtmlInput userInput = loginForm.getInputByName("username");
        userInput.setValueAttribute(user);
        HtmlInput passwordInput = loginForm.getInputByName("password");
        passwordInput.setValueAttribute(password);
        HtmlInput submit = loginForm.getInputByName("submit");
        mainPage = submit.click();
        HtmlPage selectionMenu = mainPage.getElementById("pt1:men-portlets:sdi::disAcr").click();
        webClient.waitForBackgroundJavaScript(2000);
        System.out.println("\n*******************************\nSelection Menu:\n*******************************\n");
        System.out.println(selectionMenu.asXml());
        logout();
    }

    public ArrayList<Course> retrieveCourses()throws IOException{
        HtmlPage selectionMenu = mainPage.getElementById("pt1:men-portlets:sdi::head").click();
        HtmlPage academicHistory = selectionMenu.getElementById("pt1:men-portlets:j_idt1").click();
        webClient.waitForBackgroundJavaScript(5000);
        ArrayList<Course> courses = new ArrayList<>();
        List<DomElement> htmlCourses = mainPage.getElementsById("pt1:men-portlets:sdi::head");
        return courses;
    }

    public void logout(){
        webClient.close();
    }

}
