package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavingsPage extends BasePage {
    @FindBy(id = "Savings")
    WebElement accountType;

    @FindBy(id = "Individual")
    WebElement ownership;

    @FindBy(id = "name")
    WebElement accountName;

    @FindBy(id = "openingBalance")
    WebElement deposit;

    @FindBy(id = "newSavingsSubmit")
    WebElement submitButton;

    @FindBy(id = "new-account-msg")
    WebElement successfulMsg;

    @FindBy(xpath = "//div[@class='h4 m-0']")
    List<WebElement> name;

    @FindBy(xpath = "//small[@class=\"text-light\" and text()='Account: Savings']")
    List<WebElement> accountTypeVerify;

    @FindBy(xpath = "//small[@class=\"text-light\" and text()='Ownership: Individual']")
    List<WebElement> accountOwnershipVerify;

    @FindBy(xpath = "//div[@class=\"h4 m-0\" and text()='Balance: $10000.00']")
    List<WebElement> accountBalanceVerify;

    public void createSavingsAccount(String name, String amount){
        accountType.click();
        ownership.click();
        accountName.sendKeys(name);
        deposit.sendKeys(amount);
        submitButton.click();
    }

    public boolean verifySavingsAccountIsCreated() {
        return successfulMsg.isDisplayed();
    }

    public String verifyAccountName() {
        return name.get(0).getText();
    }
    public String verifySavingsAccountType() {
        return accountTypeVerify.get(0).getText().split(" ")[1];
    }
    public String verifySavingsAccountOwnership() {
        return accountOwnershipVerify.get(0).getText().split(" ")[1];
    }
    public String verifySavingsAccountBalance() {
        return accountBalanceVerify.get(0).getText().split("\\$")[1];
    }
}
