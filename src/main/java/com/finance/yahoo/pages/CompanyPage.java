package com.finance.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage{

    @FindBy(xpath = "//span[text()='Forward Dividend & Yield']/../following-sibling::td")
    private WebElement dividendYield;

    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticsTab;

    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    private WebElement priceBook;


    public CompanyPage(WebDriver driver) {
        super(driver);
    }
    public String getDividendYield (){
        return dividendYield.getText();
    }
    public void clickStatistic(){
        statisticsTab.click();
    }
    public String getPriceBook(){
        return priceBook.getText();
    }

}
