package com.finance.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{


    @FindBy(name = "agree")
    private WebElement agreement;

    @FindBy(id = "header-signin-link")
    private WebElement signIn;

    public HomePage (WebDriver driver){
        super(driver);
    }

    public SignInPage login(){
        agreement.click();
        signIn.click();
        return new SignInPage(driver);
    }
}
