package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://qa2.madison.com")
public class HomePage extends PageObject {

    @FindBy(css=".account-cart-wrapper  a[class$=\"skip-account\"] span.label")
    private WebElementFacade accountLink;

    @FindBy(css="#header-account li")
    private List<WebElementFacade> accountList;

    public void accountOptions(){
        int noOptions=accountList.size();
        WebElement option=accountList.get(noOptions-1);
        clickOn(option);
    }
    public void navigateToUrl(String url){
        getDriver().get(url);
    }
    public void clickAccountLink() {
        accountLink.click();
    }



}