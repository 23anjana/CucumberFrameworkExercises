package com.automation.steps;

import com.automation.pages.SignUpPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpSteps {

    SignUpPage signUpPage = new SignUpPage();

    @Given("user opens the website")
    public void userOpensTheWebsite() {
        signUpPage.openWebsite();
    }

    @When("user clicks on signUp button")
    public void userClicksOnSignUpButton() {
        signUpPage.clickSignUp();
    }

    @Then("verify user is on signup page")
    public void verify_user_is_on_signup_page() {
        Assert.assertTrue(signUpPage.isSignInButtonDisplayed());
    }

    @And("user fills the first section of signUp page")
    public void user_fills_the_first_section_of_sign_up_page() {
        signUpPage.signUpFirstSession(ConfigReader.getConfigValue("firstname"),
                ConfigReader.getConfigValue("lastname"),
                ConfigReader.getConfigValue("dob"),
                ConfigReader.getConfigValue("socialsecurityno"),
                ConfigReader.getConfigValue("email"),
                ConfigReader.getConfigValue("password"),
                ConfigReader.getConfigValue("confirm.password"));
    }

    @When("user clicks on next")
    public void user_clicks_on_next() {
        signUpPage.clickOnNextButton();
    }

    @And("user fills out the rest of section in signUp page")
    public void user_fills_out_the_rest_of_section_in_sign_up_page() {
     signUpPage.signUpSecondSession(ConfigReader.getConfigValue("address"),
                ConfigReader.getConfigValue("locality"),
                ConfigReader.getConfigValue("region"),
                ConfigReader.getConfigValue("pin"),
                ConfigReader.getConfigValue("country"),
                ConfigReader.getConfigValue("homePhone"),
                ConfigReader.getConfigValue("mobilePhone"),
                ConfigReader.getConfigValue("workPhone"));
    }

    @When("user clicks on Register")
    public void user_clicks_on_register() {
        signUpPage.clickOnRegisterButton();
    }

}
