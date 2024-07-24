package com.automation.steps;

import com.automation.pages.CheckingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckingSteps {
    CheckingPage checkingPage=new CheckingPage();

    @And("create new checking account")
    public void createNewCheckingAccount() {
        checkingPage.createCheckingAccount(ConfigReader.getConfigValue("account.name"),
                ConfigReader.getConfigValue("deposit.amount"));
    }

    @Then("verify checking account is created")
    public void verifyCheckingAccountIsCreated() {
        Assert.assertTrue(checkingPage.verifyCheckingAccountCreated());
        Assert.assertEquals(ConfigReader.getConfigValue("account.name"),checkingPage.verifyCheckingAccountName());
        Assert.assertEquals(String.format("%.2f",(Double.parseDouble(ConfigReader.getConfigValue("deposit.amount")))), checkingPage.verifyCheckingAccountBalance());
        Assert.assertEquals("Standard",checkingPage.verifyCheckingAccountType());
        Assert.assertEquals("Individual",checkingPage.verifyCheckingAccountOwnership());

    }
}
