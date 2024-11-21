package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators with @FindBy annotation
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement displayTitle;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;


    public String getWebpageTitle() {
        return driver.getTitle();
    }

    public String getFormTitle() {
        return displayTitle.getText();
    }

    public void enterUsername(String username) {
        usernameTextField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
