package com.finance.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewHomePage extends BasePage {
    @FindBy(name = "agree")
    private WebElement agreement;

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchField;

    @FindBy(xpath = "//li[@id='result-quotes-0']")
    private WebElement amazonPage;

    @FindBy(xpath = "//li[@title='Apple Inc.'][1]")
    private WebElement applePage;



    public NewHomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptTermsAndConditions(){
        agreement.click();
    }

    public CompanyPage typeCompanyName(String companyNameType){


        searchField.sendKeys(companyNameType);

        if (companyNameType == "Apple") {

            applePage.click();
        }else {
            amazonPage.click();
        }

        return new CompanyPage(driver);

    }


}
