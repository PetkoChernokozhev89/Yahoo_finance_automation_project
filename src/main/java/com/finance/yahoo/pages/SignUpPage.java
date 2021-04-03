package com.finance.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
    @FindBy(id = "usernamereg-firstName")
    private WebElement firstName;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastName;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailAddress;

    @FindBy(id = "usernamereg-password")
    private WebElement password;

    @FindBy(id = "usernamereg-phone")
    private WebElement mobilePhoneNumber;

    @FindBy(id = "usernamereg-month")
    private WebElement birthMonth;

    @FindBy(id = "usernamereg-day")
    private WebElement dayOfBirth;

    @FindBy(id = "usernamereg-year")
    private WebElement yearOfBirth;

    @FindBy(id = "reg-submit-button")
    private WebElement registrationButton;

    @FindBy(id = "reg-error-yid")
    private WebElement errorEmailAddress;

    @FindBy(id = "reg-error-password")
    private WebElement errorPassword;

    @FindBy(id = "reg-error-phone")
    private WebElement errorPhone;

    @FindBy(id = "reg-error-birthDate")
    private WebElement errorBirthDay;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void inPutData(String firstNameField, String lastNameField, String emailAddressField, String passwordField, String phoneNumberField, String monthOfBirthField, String dayOfBirthField, String yearOfBirthField) {
        firstName.sendKeys(firstNameField);
        lastName.sendKeys(lastNameField);
        emailAddress.sendKeys(emailAddressField);
        password.sendKeys(passwordField);
        mobilePhoneNumber.sendKeys(phoneNumberField);
        Select list = new Select(birthMonth);
        list.selectByValue(monthOfBirthField);
        dayOfBirth.sendKeys(dayOfBirthField);
        yearOfBirth.sendKeys(yearOfBirthField);
        registrationButton.click();

    }

    /*public String errorMessages() {
         errorEmailAddress.getText();
         errorPassword.getText();
         errorPhone.getText();
         errorBirthDay.getText();

         return errorMessages();*/


    }




