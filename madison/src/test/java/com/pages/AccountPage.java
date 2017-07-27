package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by ioanavaidasegan on 27-Jul-17.
 */
public class AccountPage extends PageObject{

   @FindBy(css=".page-title h1")
    private WebElementFacade message;

   @FindBy(css=".header-minicart ")
   private WebElementFacade cart;

   @FindBy(css="a.cart-link")
   private WebElementFacade cartLink;

public String accountMessage(){
    String accountMessage=message.getText();
    return accountMessage;
}

public void headerCart(){
    cart.click();
}

public void viewShoppingCart(){
    //element(cart).waitUntilVisible();
    cartLink.click();
}

}