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

    HomePage openHomePage;
    HomePage clickAccountLink;
    HomePage clickOnTheLoginPage;
    RedirectToLoginPage enterMailData;
    RedirectToLoginPage enterPasswordData;
    AccountPage accountTextMessage;
    RedirectToLoginPage logInButton;
    RedirectToLoginPage invalidData;
    AccountPage cartButton;
    AccountPage goToCartLink;
    ShoppingCartPage shoppingTextMessage;

    @Step
    public void navigateTo(String url) {
        openHomePage.navigateToUrl(url);
    }

    @Step
    public void clickOnTheAccountLink() {
        clickAccountLink.clickAccountLink();
    }

    @Step
    public void clickOnTheLoginLink(){
        clickOnTheLoginPage.accountOptions();
    }

    @Step
    public void inputMailData(String mail){
        enterMailData.inputDataMail(mail);
    }

    @Step
    public void inputPasswordData(String passw){
        enterPasswordData.inputDataPassword(passw);
    }

    @Step
    public void pressTheLoginButton(){
        logInButton.pressLogin();
    }


    @Step
    public void verifyIfTheUserIsLoggedin(String expectedMessage){
        String messageAccount=accountTextMessage.accountMessage().toUpperCase();
        System.out.println("message: " + messageAccount);
        System.out.println("given: " + expectedMessage);
        Assert.assertTrue("You are not in the account: ", expectedMessage.contentEquals(messageAccount));
    }

    @Step
    public void verifyIfInvalidUserIsRejected(String expectedMessage){
        String message=invalidData.messageForInvalidLogIn();
        Assert.assertTrue("The username or password is invalid: ",expectedMessage.contentEquals(message));
    }

    @Step
    public void clickOnTheCartIcon(){
        cartButton.headerCart();
    }

    @Step
    public void clickOnViewShoppingCart(){
        goToCartLink.viewShoppingCart();
    }

    @Step
    public void verifyIfUserIsInShoppingCart(String expectedMessage){
        String message=shoppingTextMessage.shoppingCartMessage();
        Assert.assertTrue("You are not in shopping cart: ",expectedMessage.contentEquals(message));

    }


}