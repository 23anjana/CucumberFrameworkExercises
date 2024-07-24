package com.automation.pages;

import com.automation.utils.ConfigReader;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

public class TransactionPage extends BasePage {

    Double lastBalance;
    Double totalSavings;
    Double transferAmount;

    @FindBy(xpath = "//a[@id='transfer-menu-item' and text()='Transfer Between Accounts']")
    WebElement transferButton;

    @FindBy(tagName = "h1")
    WebElement verifyTransactionPage;

    @FindBy(id = "fromAccount")
    WebElement fromAccountSelection;

    @FindBy(id = "toAccount")
    WebElement toAccountSelection;

    @FindBy(id = "amount")
    WebElement mentionTransferAmount;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-sm\"]")
    WebElement submitButton;

    @FindBy(xpath = "//tbody/tr/td[text()='845329342 (TRN) - Transfer from Account (486137102)']")
    List<WebElement> transferDetailsList;

    @FindBy(xpath = "//div[@class='h4 m-0']")
    List<WebElement> balanceAmountSavings;



    public void clickOnTransferButton() {
        transferButton.click();
    }
    public void verifyUserOnTransactionPage() {
        verifyTransactionPage.isDisplayed();
    }
    public void makeTransactionSelection() {
        Select dropDown = new Select(fromAccountSelection);
        dropDown.selectByValue("33794");

        Select dropDown2 = new Select(toAccountSelection);
        dropDown2.selectByValue("33797");
//        fromAccountSelection.click();
        //toAccountSelection.click();
    }
    public void writeTransactionAmount(String transferAmount) {
        mentionTransferAmount.sendKeys(transferAmount);
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }
    public Double transactionSuccessful() {
        return Double.parseDouble(balanceAmountSavings.get(1).getText().split("\\$")[1]);

//        List<String> listOfBalance = new ArrayList<>();
//        for(WebElement balance : balanceSavings) {
//            listOfBalance.add(balance.getText());
//        }
//        lastBalance = Double.parseDouble(listOfBalance.get(0));
//        transferAmount;

    }
}
