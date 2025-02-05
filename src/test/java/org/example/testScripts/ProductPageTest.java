package org.example.testScripts;

import lombok.extern.java.Log;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    private ProductPage productPage;
    private LoginPage loginPage;
    private LoginPageTest loginPageTest;

    @BeforeClass
    public void pageSetup() {
        productPage = new ProductPage(driver);
    }

    @BeforeMethod
    public void loginToWebsite() {
        login();
    }

    @Test(priority = 1)
    public void testProductCard() {
        Assert.assertTrue(productPage.getPageTitle().contains("Products"));
        Assert.assertEquals(productPage.getTitleSauceLabsBackpack(), "Sauce Labs Backpack");
        Assert.assertEquals(productPage.getDescSauceLabsBackpack(), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertTrue(productPage.getPriceSauceLabsBackpack().getText().contains("29.99"));
    }

}
