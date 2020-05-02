package com.blackpixl.unalapp.connection;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

public class Connection {
    public Connection(String user, String password) throws IOException{
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(10000);
        HtmlPage loginPage = webClient.getPage("https://sia.unal.edu.co/ServiciosApp");
        HtmlForm loginForm = loginPage.getFormByName("frmLogin");
        HtmlInput userInput = loginForm.getInputByName("username");
        userInput.setValueAttribute(user);
        HtmlInput passwordInput = loginForm.getInputByName("password");
        passwordInput.setValueAttribute(password);
        HtmlInput submit = loginForm.getInputByName("submit");
        mainPage = submit.click();
    }

    final static WebClient webClient = new WebClient(BrowserVersion.FIREFOX_68);
    HtmlPage mainPage;

    public String getMainPage() {
        return mainPage.asText();
    }

    public static void close(){
        webClient.close();
    }

}
