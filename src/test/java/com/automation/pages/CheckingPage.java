package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckingPage extends BasePage {
    @FindBy(id = "Standard Checking")
    WebElement accountType;

    @FindBy(id = "Individual")
    WebElement accountOwnership;

    @FindBy(id = "name")
    WebElement accountName;

    @FindBy(id = "openingBalance")
    WebElement deposit;

    @FindBy(id = "newCheckingSubmit")
    WebElement submitButton;

    @FindBy(id = "new-account-msg")
    WebElement successfulMsg;

    @FindBy(xpath = "//small[@class=\"text-light\" and text()='Ownership: Individual']")
    List<WebElement> accountNumber;

    @FindBy(xpath = "//div[@class='h4 m-0' and text()='abc']")
    List<WebElement> accountNameVerify;

    @FindBy(xpath = "//small[@class=\"text-light\" and text()='Account: Standard Checking']")
    List<WebElement> accountTypeVerify;

    @FindBy(xpath = "//small[@class=\"text-light\" and text()='Ownership: Individual']")
    List<WebElement> accountOwnershipVerify;

    @FindBy(xpath = "//div[@class=\"h4 m-0\" and text()='Balance: $20000.00']")
    List<WebElement> accountBalanceVerify;

    public void createCheckingAccount(String name, String amount){
        accountType.click();
        accountOwnership.click();
        accountName.sendKeys(name);
        deposit.sendKeys(amount);
        submitButton.click();
    }

    public boolean verifyCheckingAccountCreated() {
        return successfulMsg.isDisplayed();
    }
    public String verifyCheckingAccountName() {
        return accountNameVerify.get(0).getText();
    }
    public String verifyCheckingAccountType() {
        return accountTypeVerify.get(0).getText().split(" ")[1];
    }
    public String verifyCheckingAccountOwnership() {
        return accountOwnershipVerify.get(0).getText().split(" ")[1];
    }
    public String verifyCheckingAccountBalance() {
        return accountBalanceVerify.get(0).getText().split("\\$")[1];
    }
}
