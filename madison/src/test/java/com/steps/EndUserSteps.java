package com.steps;

import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.RedirectToLoginPage;
import com.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps{


    HomePage homePage;
    RedirectToLoginPage redirectToLoginPage;
    AccountPage accountPage;
    ShoppingCartPage shoppingCartPage;


    @Step
    public void navigateTo(String url) {
        homePage.navigateToUrl(url);
    }

    @Step
    public void clickOnTheAccountLink() {
        homePage.clickAccountLink();
    }

    @Step
    public void clickOnTheLoginLink(){
        homePage.accountOptions();
    }

    @Step
    public void inputMailData(String mail){
        redirectToLoginPage.inputDataMail(mail);
    }

    @Step
    public void inputPasswordData(String passw){
        redirectToLoginPage.inputDataPassword(passw);
    }

    @Step
    public void pressTheLoginButton(){
        redirectToLoginPage.pressLogin();
    }

    @Step
    public void verifyIfTheUserIsLoggedin(String expectedMessage){
        String messageAccount= accountPage.accountMessage().toUpperCase();
        System.out.println("message: " + messageAccount);
        System.out.println("given: " + expectedMessage);
        Assert.assertTrue("You are not in the account: ", expectedMessage.contentEquals(messageAccount));
    }

    @Step
    public void verifyIfInvalidUserIsRejected(String expected){
        String message=redirectToLoginPage.messageForInvalidLogIn();
        Assert.assertTrue("The username or password is invalid: ",expected.contentEquals(message));
    }

    @Step
    public void clickOnTheCartIcon(){
        accountPage.headerCart();
    }

    @Step
    public void clickOnViewShoppingCart(){
        accountPage.viewShoppingCart();
    }

    @Step
    public void verifyIfUserIsInShoppingCart(String expectedMessage){
        String message= shoppingCartPage.shoppingCartMessage();
        Assert.assertTrue("You are not in shopping cart: ",expectedMessage.contentEquals(message));
    }
    @Step
    public void clickInTheQuantityField(){
        shoppingCartPage.activateQuantityField();
    }
    @Step
    public void clearTheQuantity(){
        shoppingCartPage.clearQuantity();
    }
    @Step
    public void modifyTheQuantityInShoppingCart(String qty){
        shoppingCartPage.modifyQuantity(qty);

    }
    @Step
    public void clickOnTheUpdateButton(){
        shoppingCartPage.updateButton();
    }


}