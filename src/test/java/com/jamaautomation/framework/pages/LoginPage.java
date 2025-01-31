package com.jamaautomation.framework.pages;

import com.jamaautomation.framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    // Locators
    private final By usernameField = By.id("j_username");
    private final By passwordField = By.id("j_password");
    private final By loginButton = By.id("loginButton");
    private final By loginVersionNumber = By.xpath("//span[@class='j-login-version-number']");

    // Methods
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Login method
    public void login(){
        enterText(usernameField, ConfigReader.getProperty("username"));
        enterText(passwordField, ConfigReader.getProperty("password"));
        clickElement(loginButton);
    }

    public String getLoginVersionNumberText(){
        return getElementText(loginVersionNumber);
    }
}
