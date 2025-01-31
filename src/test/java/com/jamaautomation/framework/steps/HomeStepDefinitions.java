package com.jamaautomation.framework.steps;

import com.jamaautomation.framework.pages.HomePage;
import io.cucumber.java.en.Then;

public class HomeStepDefinitions{

    @Then("I navigate to Stream Page")
    public void INavigateToStreamPage()
    {
        HomePage homePage = new HomePage(Hooks.driver);
        homePage.clickStreamMenu();
    }
}
