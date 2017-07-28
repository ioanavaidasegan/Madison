package com.tests;

import javafx.application.Application;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;

import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;
import sun.security.pkcs11.wrapper.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= "CSV/Login.csv")
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl="CSV")
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;
    String mail,password;


    @Before
    public void maximize()
    {
    webdriver.manage().window().maximize();
    }

    @Test
    public void clickOnAccountAndLogin() {

        endUserSteps.navigateTo("http://qa2.madison.com");
        endUserSteps.clickOnTheAccountLink();
        endUserSteps.clickOnTheLoginLink();
        System.out.println("Am ajuns la mail: ");
        endUserSteps.inputMailData(mail);
        endUserSteps.inputPasswordData(password);
        endUserSteps.pressTheLoginButton();
        endUserSteps.verifyIfTheUserIsLoggedin("MY DASHBOARD");
        endUserSteps.clickOnTheCartIcon();
        endUserSteps.clickOnViewShoppingCart();
        endUserSteps.verifyIfUserIsInShoppingCart("SHOPPING CART");
        endUserSteps.clickInTheQuantityField();
        endUserSteps.clearTheQuantity();
        System.out.println("Crystal Clear");
        endUserSteps.modifyTheQuantityInShoppingCart("5");
        System.out.println();
        endUserSteps.clickOnTheUpdateButton();

    }

    @Test
    public void negativeDataTypeForLogin(){
        endUserSteps.navigateTo("http://qa2.madison.com");
        endUserSteps.clickOnTheAccountLink();
        endUserSteps.clickOnTheLoginLink();
        System.out.println("Am ajuns la mail: ");
        endUserSteps.inputMailData("test11@gmail.com");
        endUserSteps.inputPasswordData("test11");
        endUserSteps.pressTheLoginButton();
        endUserSteps.verifyIfInvalidUserIsRejected("Invalid login or password.");
    }
} 