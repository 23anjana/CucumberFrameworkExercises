package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//a[text()=' Sign Up Here']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[text()=' Sign in']")
    WebElement signInButton;

    @FindBy(id = "title")
    WebElement titleButton;

    @FindBy(id = "firstName")
    WebElement selectFirstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//input[@value='F']")
    WebElement genderF;

    @FindBy(id = "dob")
    WebElement dob;

    @FindBy(id = "ssn")
    WebElement socialSecurityNumber;

    @FindBy(id = "emailAddress")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(tagName = "button")
    WebElement nextButton;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "locality")
    WebElement locality;

    @FindBy(id = "region")
    WebElement region;

    @FindBy(id = "postalCode")
    WebElement postalCode;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "homePhone")
    WebElement homePhone;

    @FindBy(id = "mobilePhone")
    WebElement mobilePhone;

    @FindBy(id = "workPhone")
    WebElement workPhone;

    @FindBy(id = "agree-terms")
    WebElement terms;

    @FindBy(tagName = "button")
    WebElement register;

    public void openWebsite(){
        driver.get("https://dbank-qa.wedevx.co/bank");
    }

    public void clickSignUp(){
        signUpButton.click();
    }

    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

    public void signUpFirstSession(String fName,String lName,String dob, String ssn,String email,String password,String password2) {

        Select titleDropDown = new Select(titleButton);
        titleDropDown.selectByValue("Ms.");

        selectFirstName.sendKeys(fName);
        lastName.sendKeys(lName);
        genderF.click();
        this.dob.sendKeys(dob);
        socialSecurityNumber.sendKeys(ssn);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        confirmPassword.sendKeys(password2);
    }
    public void clickOnNextButton() {
        nextButton.click();
    }
    public void signUpSecondSession(String address,String locality,String region,String post, String country,String hPhone,String mPhone, String wPhone) {
        this.address.sendKeys(address);
        this.locality.sendKeys(locality);
        this.region.sendKeys(region);
        postalCode.sendKeys(post);
        this.country.sendKeys(country);
        homePhone.sendKeys(hPhone);
        mobilePhone.sendKeys(mPhone);
        workPhone.sendKeys(wPhone);
        terms.click();
    }
    public void clickOnRegisterButton() {
        register.click();
    }
}
