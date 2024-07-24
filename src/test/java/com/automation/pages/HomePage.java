package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(id = "page-title")
    WebElement dashboard;

    @FindBy(css = ".active")
    WebElement welcomeTest;

    @FindBy(id = "checking-menu")
    WebElement checkingMenu;

    @FindBy(id = "new-checking-menu-item")
    WebElement newCheckingMenu;

    @FindBy(id = "savings-menu")
    WebElement savingsMenu;

    @FindBy(id = "new-savings-menu-item")
    WebElement newSavingsMenu;

    public boolean isHomepageDisplayed(){
        return dashboard.isDisplayed() && welcomeTest.isDisplayed();
    }

    public void newCheckingAccount(){
        checkingMenu.click();
        newCheckingMenu.click();
    }

    public void newSavingsAccount(){
        savingsMenu.click();
        newSavingsMenu.click();
    }
}
