package com.automation.steps;

import com.automation.pages.SavingsPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SavingsSteps {
    SavingsPage savingsPage=new SavingsPage();

    @And("create new savings account")
    public void createNewSavingsAccount() {
        savingsPage.createSavingsAccount(ConfigReader.getConfigValue("savings.account.name"),
                ConfigReader.getConfigValue("savings.deposit"));
    }

    @Then("verify savings account is created")
    public void verifySavingsAccountIsCreated() {
        Assert.assertTrue(savingsPage.verifySavingsAccountIsCreated());
    }

    @And("verify created account details")
    public void verifyCreatedAccountDetails() {
        Assert.assertEquals(ConfigReader.getConfigValue("savings.account.name"), savingsPage.verifyAccountName());
        Assert.assertEquals(String.format("%.2f",(Double.parseDouble(ConfigReader.getConfigValue("savings.deposit")))), savingsPage.verifySavingsAccountBalance());
        Assert.assertEquals("Savings",savingsPage.verifySavingsAccountType());
        Assert.assertEquals("Individual",savingsPage.verifySavingsAccountOwnership());

    }
}
