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

    @FindBy(css="td.product-cart-actions input[title*=Qty]")
    private WebElementFacade clearQuantityOfTheField;

    @FindBy(css="td.product-cart-actions input[title*=Qty]")
    private WebElementFacade modifyQuantity;

    @FindBy(css="button.button.btn-update")
    private WebElementFacade update;

    @FindBy(css="td.product-cart-actions input[title*=Qty]")
    private WebElementFacade clickInField;

    public String shoppingCartMessage() {
        String cartMessage = shopping.getText().toUpperCase();
        return cartMessage;
    }

    public void activateQuantityField(){
        clickInField.click();
    }

    public void clearQuantity() {
        clearQuantityOfTheField.clear();
    }

    public void modifyQuantity(String number){
        modifyQuantity.type(number);
    }

    public void updateButton(){
        update.click();
    }


    }

