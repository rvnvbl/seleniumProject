package org.example.testScripts;

import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{


    private LoginPage loginPage;

    @BeforeClass
    public void pageSetup(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginPageTitle(){
        String pageTitle = loginPage.getWebpageTitle();
        Assert.assertEquals(pageTitle,"Swag Labs");
    }

    @Test(priority = 1)
    public void testFormTitle(){
        String formTitle = loginPage.getFormTitle();
        Assert.assertEquals(formTitle, "Swag Labs");
    }

    @Test(priority = 2)
    public void testLogin(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        System.out.println(productPage.getPageTitle());
        Assert.assertTrue(productPage.getPageTitle().contains("Products"));
    }
}
