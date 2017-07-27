package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by ioanavaidasegan on 26-Jul-17.
 */
public class RedirectToLoginPage extends PageObject{

    @FindBy(css="#email")
    private WebElementFacade emailField;

    @FindBy(css="#pass")
    private WebElementFacade passwordField;

    @FindBy(css="#send2")
    private WebElementFacade loginButton;

    @FindBy(css=".error-msg")
    private WebElementFacade message;

    public void inputDataMail(String mail){
        emailField.sendKeys(mail);
    }

    public void inputDataPassword (String password){
        passwordField.sendKeys(password);
    }

    public void pressLogin(){
        loginButton.click();
    }

    public String messageForInvalidLogIn(){
        String messageLogin=message.getText();
        return messageLogin;
    }



}
