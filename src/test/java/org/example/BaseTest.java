package org.example;

import org.example.config.ConfigReader;
import org.example.config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader;

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
}
