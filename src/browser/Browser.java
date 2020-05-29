package browser;

import course.Course;
import course.CurrentCourse;
import jsonParser.JsonParser;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import user.AcademicHistory;
import user.User;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        HtmlPage loginPage = webClient.getPage("https://sia.unal.edu.co/ServiciosApp/");
        System.out.println("\n*******************************\nloading LoginPage");
        webClient.waitForBackgroundJavaScript(5000);
        System.out.println("\n*******************************\nloaded LoginPage:\n*******************************\n");
        System.out.println(loginPage.asXml());

        HtmlForm loginForm = loginPage.getFormByName("frmLogin");
        HtmlInput userInput = loginForm.getInputByName("username");
        userInput.setValueAttribute(user);
        HtmlInput passwordInput = loginForm.getInputByName("password");
        passwordInput.setValueAttribute(password);
        HtmlInput submit = loginForm.getInputByName("submit");
        mainPage = submit.click();

        HtmlPage selectionMenu = mainPage.getElementById("pt1:men-portlets:sdi::disAcr").click();
        webClient.waitForBackgroundJavaScript(5000);
        System.out.println("\n*******************************\nSelection Menu:\n*******************************\n");
        System.out.println(selectionMenu.asXml());
        System.out.println("\n*******************************\nAcademic History:\n*******************************\n");
        HtmlPage academicHistory = selectionMenu.getElementById("pt1:men-portlets:j_idt1").click();
        webClient.waitForBackgroundJavaScript(10000);
        System.out.println(academicHistory.asXml());
    }

    public AcademicHistory retrieveAcademicHistory() throws IOException {

        //TODO: Connect with real webClient

        String path = "file:\\\\\\\\C:\\\\Users\\\\javi-\\\\Documents\\\\UnalApp\\\\Portal de Servicios Académicos3.htm";

        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage academicHistory = webClient.getPage(path);

        List<DomElement> nombres = academicHistory.getByXPath("//td[contains(@id, 'pt1:r1:1:t17:0:c24')]");
        List<DomElement> creditos = academicHistory.getByXPath("//td[contains(@id, 'pt1:r1:1:t17:0:c25')]");
        List<DomElement> tipologia = academicHistory.getByXPath("//td[contains(@id, 'pt1:r1:1:t17:0:c26')]");
        List<DomElement> semestre = academicHistory.getByXPath("//td[contains(@id, 'pt1:r1:1:t17:0:c27')]");
        List<DomElement> calificacion = academicHistory.getByXPath("//td[contains(@id, 'pt1:r1:1:t17:0:c23')]");

        ArrayList<Course> courses = new ArrayList<>();

        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i).getTextContent();
            String credits = creditos.get(i).getTextContent();
            String type = tipologia.get(i).getTextContent();
            String sem = semestre.get(i).getTextContent();
            String calif = calificacion.get(i).getTextContent();
            String codigo = getFromString(nombre,"\\([0-9]+\\-?[a-zA-Z]?\\)");
            String calification = getFromString(calif, "[0-9]\\.[0-9]+");
            String tipo = getFromString(calif, "[a-zA-Z]+");
            courses.add(new Course(nombre,
                    codigo,
                    calification,
                    Integer.parseInt(credits),
                    sem,
                    type,
                    tipo));
        }

        return new AcademicHistory(courses);
    }

    public ArrayList<CurrentCourse> retrieveCurrentCourses() throws IOException {
        //(1) - nota-cuerpo af_panelGroupLayout || salto nota-listado af_panelGroupLayout
        //(2) - nota-nombre-asignatura af_panelGroupLayout && nota-calificacion-observacion af_panelGroupLayout
        //(3) -      ^^^^^^^^^^^^^^^^^                             ^^^^^^^^^^^^
        String path = "file:\\\\\\\\C:\\\\Users\\\\javi-\\\\Documents\\\\UnalApp\\\\Portal de Servicios Académicos5.htm";
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage current = webClient.getPage(path);
        List<DomElement> elems = current.getByXPath("//span[contains(@class, 'salto nota-listado af_panelGroupLayout')]");
        List<DomElement> elems1 = elems.get(0).getByXPath("//span[contains(@class, 'nota-nombre-asignatura af_panelGroupLayout')]");
        List<DomElement> elems2 = elems.get(0).getByXPath("//span[contains(@class, 'nota-calificacion-observacion af_panelGroupLayout')]");
        ArrayList<CurrentCourse> currentCourses = new ArrayList<>();
        for (int i = 0; i < elems1.size(); i++) {
            String nombre = elems1.get(i).getTextContent();
            String codigo = getFromString(nombre,"\\([0-9]+\\-?[a-zA-Z]?\\)");
            String calific = getFromString(elems2.get(i).getTextContent(),"[0-9]\\.[0-9]+");
            currentCourses.add(new CurrentCourse(nombre, codigo, calific));
        }
        return currentCourses;
    }

    public void logout(){
        webClient.close();
    }

    public HtmlPage login() throws IOException{
        HtmlPage loginPage = webClient.getPage("https://sia.unal.edu.co/ServiciosApp/");
        System.out.println("\n*******************************\nloading LoginPage");
        webClient.waitForBackgroundJavaScript(5000);
        System.out.println("\n*******************************\nloaded LoginPage:\n*******************************\n");
        System.out.println(loginPage.asXml());
        return loginPage;
    }

    public String getFromString(String originalString, String regex) {
        String matchedPattern;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(originalString);
        if (matcher.find()) {
            matchedPattern = matcher.group();
        } else {
            matchedPattern = "N/A";
        }
        return matchedPattern;
    }
}

//TODO: A METHOD TO DEAL WITH LISTS AND ITS CONTENTS.

/*  OLD "RETRIEVEACADEMICHISTORY()" CODE

    HtmlPage selectionMenu = mainPage.getElementById("pt1:men-portlets:sdi::head").click();
    HtmlPage academicHistory = selectionMenu.getElementById("pt1:men-portlets:j_idt1").click();
    webClient.waitForBackgroundJavaScript(5000);

 */
