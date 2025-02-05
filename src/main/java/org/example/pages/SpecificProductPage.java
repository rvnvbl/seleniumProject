package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificProductPage {

    private WebDriver driver;

    public SpecificProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@name='back-to-products']")
    WebElement buttonBackToProducts;

    @FindBy (xpath = "//button[@id='add-to-cart']")
    WebElement buttonAddToCart;

    public void clickButtonBackToProducts( ) {
        buttonBackToProducts.click();
    }

    public void clickAddToCartButton(){
        buttonAddToCart.click();
    }
}
