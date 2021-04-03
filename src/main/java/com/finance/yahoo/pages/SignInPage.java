package com.finance.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
    @FindBy(id = "createacc")
    private WebElement createAcc;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage createButton() {
        createAcc.click();
        return new SignUpPage(driver);
    }
}
