package com.jamaautomation.framework.pages;

import com.jamaautomation.framework.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected WaitHelper waitHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    protected WebElement findElement(By locator) {
        return waitHelper.waitForElementToBeVisible(locator);
    }

    protected void clickElement(By locator) {
        WebElement element = waitHelper.waitForElementToBeClickable(locator);
        element.click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = waitHelper.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(By locator) {
        return waitHelper.waitForElementToBeVisible(locator).getText();
    }
}
