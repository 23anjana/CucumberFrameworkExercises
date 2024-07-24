package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is on banking page")
    public void verify_user_is_on_banking_page() {
        Assert.assertTrue(homePage.isHomepageDisplayed());
    }

    @When("user click new checking from checking")
    public void userClickNewCheckingFromChecking() {
        homePage.newCheckingAccount();
    }

    @When("user click new savings account from savings menu")
    public void userClickNewSavingsAccountFromSavingsMenu() {
        homePage.newSavingsAccount();
    }
}
