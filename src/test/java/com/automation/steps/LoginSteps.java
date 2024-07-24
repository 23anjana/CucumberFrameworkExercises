package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage=new LoginPage();

    @Given("user open the website")
    public void user_open_the_website() {
        loginPage.openWebsite();
    }

    @When("click on signup from the login page")
    public void click_on_signup_from_the_login_page() {
        loginPage.clickSignUp();
    }



    @Then("verify registration is successful")
    public void verify_registration_is_successful() {
        Assert.assertTrue(loginPage.ValidateSuccessfulRegistration());
    }



    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user login using username {string} and password {string}")
    public void userLoginUsingUsernameAndPassword(String usernameKey, String passwordKey) {
        loginPage.doLogin(ConfigReader.getConfigValue(usernameKey), ConfigReader.getConfigValue(passwordKey));
    }
}
