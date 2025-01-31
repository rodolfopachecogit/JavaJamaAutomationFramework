package com.jamaautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    // Locators
    private final By streamMenu = By.xpath("//nav[@id='j-contour-header-tabs']//a[text()='Stream']");

    // Methods
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickStreamMenu(){
        clickElement(streamMenu);
    }
}
