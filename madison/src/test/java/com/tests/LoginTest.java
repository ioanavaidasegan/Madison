package com.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EndUserSteps;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps openHomePageStep;

    @Steps
    public EndUserSteps clickAccountLinkStep;

    @Steps
    public EndUserSteps clickOnTheLoginPageStep;

    @Steps
    public EndUserSteps enterMailDataStep;

    @Steps
    public EndUserSteps enterPasswordDataStep;

    @Steps
    public EndUserSteps pressloginStep;

    @Steps
    public EndUserSteps accountMessageStep;

    @Steps
    public EndUserSteps cartButtonStep;

    @Steps
    public EndUserSteps cartLinkStep;

    @Steps
    public EndUserSteps shoppingCartstep;

    @Steps
    public EndUserSteps clearQuantityStep;

    @Steps
    public EndUserSteps modifyQuantityStep;

    @Steps
    public EndUserSteps updatequantityStep;

    @Steps
    public EndUserSteps clickInTheQuantityFieldStep;



    @Before
    public void maximize(){
    webdriver.manage().window().maximize();
    }

    @Test
    public void clickOnAccountAndLogin() {

        openHomePageStep.navigateTo("http://qa2.madison.com");
        clickAccountLinkStep.clickOnTheAccountLink();
        clickOnTheLoginPageStep.clickOnTheLoginLink();
        System.out.println("Am ajuns la mail: ");
        enterMailDataStep.inputMailData("test@gmail.com");
        enterPasswordDataStep.inputPasswordData("test11");
        pressloginStep.pressTheLoginButton();
        accountMessageStep.verifyIfTheUserIsLoggedin("MY DASHBOARD");
        cartButtonStep.clickOnTheCartIcon();
        cartLinkStep.clickOnViewShoppingCart();
        shoppingCartstep.verifyIfUserIsInShoppingCart("SHOPPING CART");
        clickInTheQuantityFieldStep.clickInTheQuantityField();
        clearQuantityStep.clearTheQuantity();
        System.out.println("Crystal Clear");
        modifyQuantityStep.modifyTheQuantityInShoppingCart("5");
        System.out.println();
        updatequantityStep.clickOnTheUpdateButton();

    }

    @Test
    public void negativeDataTypeForLogin(){
        openHomePageStep.navigateTo("http://qa2.madison.com");
        clickAccountLinkStep.clickOnTheAccountLink();
        clickOnTheLoginPageStep.clickOnTheLoginLink();
        System.out.println("Am ajuns la mail: ");
        enterMailDataStep.inputMailData("test11@gmail.com");
        enterPasswordDataStep.inputPasswordData("test11");
        pressloginStep.pressTheLoginButton();
        accountMessageStep.verifyIfInvalidUserIsRejected("Invalid login or password.");
    }
} 