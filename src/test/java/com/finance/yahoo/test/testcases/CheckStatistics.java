
package com.finance.yahoo.test.testcases;

import com.finance.yahoo.pages.CompanyPage;
import com.finance.yahoo.pages.NewHomePage;
import com.finance.yahoo.test.base.TestUtil;
import com.finance.yahoo.util.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CheckStatistics extends TestUtil {
    @DataProvider(name = "companies-Data")
    public static Object[][] dataProviderFromCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companies-data.csv");
    }

    @Test(dataProvider = "companies-Data")
    public void executeTest(String companyName, String dividendRate, String priceBook) {
        NewHomePage newHomePage = new NewHomePage(driver);
        newHomePage.acceptTermsAndConditions();
        CompanyPage companyPage = newHomePage.typeCompanyName(companyName);
        companyPage.clickStatistic();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(companyPage.getDividendYield(), dividendRate);
        softAssert.assertEquals(companyPage.getPriceBook(), priceBook);
        softAssert.assertAll();


    }


}

