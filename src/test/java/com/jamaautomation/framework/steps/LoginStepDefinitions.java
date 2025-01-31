package com.jamaautomation.framework.steps;

import com.jamaautomation.framework.pages.LoginPage;
import com.jamaautomation.framework.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;

public class LoginStepDefinitions {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage = new LoginPage(Hooks.driver);
        Hooks.driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login();
    }

    @Then("I validate version text is displayed")
    public void i_validate_version_text_is_displayed()
    {
        assertFalse("Version should not be empty", loginPage.getLoginVersionNumberText().isEmpty());
    }
}
