package com.automation.steps;

import com.automation.pages.TransactionPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TransactionSteps {

    TransactionPage transactionPage = new TransactionPage();

    @When("user clicks on Transfer button")
    public void userClicksOnTransferButton() {
        transactionPage.clickOnTransferButton();
    }

    @Then("verify user is on transaction page")
    public void verifyUserIsOnTransactionPage() {
        transactionPage.verifyUserOnTransactionPage();
    }

    @And("user selects the appropriate transaction details")
    public void userSelectsTheAppropriateTransactionDetails() {
        transactionPage.makeTransactionSelection();
        transactionPage.writeTransactionAmount(ConfigReader.getConfigValue("transfer.amount"));
    }

    @When("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        transactionPage.clickOnSubmitButton();
    }

    @Then("verify the successful transaction")
    public void verifyTransactionDoneSuccessfully() {
        Double totalBalance = Double.parseDouble(ConfigReader.getConfigValue("savings.deposit")) +
                Double.parseDouble(ConfigReader.getConfigValue("transfer.amount"));
                Assert.assertEquals(totalBalance, transactionPage.transactionSuccessful());
    }
}
