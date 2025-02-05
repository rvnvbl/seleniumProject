package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@id='item_4_title_link']")
     private WebElement titleSauceLabsBackpack;

    @FindBy(xpath ="//button[@name='add-to-cart-sauce-labs-backpack']")
    private  WebElement buttonSauceLabsBackpack;

    @FindBy(xpath = "//img[@alt ='Sauce Labs Backpack']")
    private WebElement imgSauceLabsBackpack;

    @FindBy(xpath = "//div[@class ='inventory_item_price']")
    private List<WebElement> priceItems;

    @FindBy(xpath = " //div[contains(text(), 'Sly Pack')]")
    private WebElement descSauceLabsBackpack;

    public String getPageTitle(){
       return pageTitle.getText();
    }

    public String getTitleSauceLabsBackpack(){
        return titleSauceLabsBackpack.getText();
    }
    public void clickSauceLabsBackpack(){
        titleSauceLabsBackpack.click();
    }

    public void clickAddToCartSauceLabsBackpack(){
        buttonSauceLabsBackpack.click();
    }

    public WebElement getImageSauceLabsBackpack (){
        return imgSauceLabsBackpack;
    }

    public String getDescSauceLabsBackpack (){
        return descSauceLabsBackpack.getText();
    }

    public WebElement getPriceSauceLabsBackpack (){
        return priceItems.get(0);
    }

}
