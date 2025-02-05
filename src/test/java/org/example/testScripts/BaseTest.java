package org.example.testScripts;

import org.example.config.ConfigReader;
import org.example.config.DriverManager;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader("src/test/resources/properties/config.properties");
        driver = DriverManager.getDriver(configReader.getStringProperty("browser"));

        if (driver != null) {
            driver.get(configReader.getStringProperty("url"));  // Open the desired URL
        } else {
            throw new IllegalStateException("WebDriver could not be initialized");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.getIntProperty("timeout")));
    }


    @AfterClass
    public void tearDown() {
        DriverManager.quitBrowser();
    }

    public void login() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

}
