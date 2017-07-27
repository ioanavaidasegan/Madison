package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by ioanavaidasegan on 27-Jul-17.
 */
public class ShoppingCartPage extends PageObject {
    @FindBy(css=".page-title.title-buttons h1")
    private WebElementFacade shopping;

    public String shoppingCartMessage(){
        String cartMessage=shopping.getText().toUpperCase();
        return cartMessage;

    }
}
