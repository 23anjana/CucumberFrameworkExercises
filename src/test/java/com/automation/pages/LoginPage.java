package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//a[text()=' Sign Up Here']")
    WebElement signUpButton;

    @FindBy(xpath = "//span[text()='Success']")
    WebElement successText;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement submit;

    public void openWebsite(){
        driver.get("https://dbank-qa.wedevx.co/bank");
    }

    public void clickSignUp(){
        signUpButton.click();
    }

    public boolean ValidateSuccessfulRegistration(){
        return successText.isDisplayed();
    }


    public void doLogin(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submit.click();
    }

    public boolean isLoginPageDisplayed(){
        return signUpButton.isDisplayed();
    }

}
