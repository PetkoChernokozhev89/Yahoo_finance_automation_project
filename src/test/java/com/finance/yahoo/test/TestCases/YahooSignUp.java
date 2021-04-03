package com.finance.yahoo.test.TestCases;

import com.finance.yahoo.pages.HomePage;
import com.finance.yahoo.pages.SignInPage;
import com.finance.yahoo.pages.SignUpPage;
import com.finance.yahoo.test.base.TestUtil;
import com.finance.yahoo.util.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class YahooSignUp extends TestUtil {
    @DataProvider(name = "login-Data")
    public static Object[][] dataProviderFromCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-Data")
    public void executeTest(String firstName, String lastName, String email, String password, String phone,String monthBirth,String dayBirth, String yearBirth) {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.login();
        SignUpPage signUpPage = signInPage.createButton();
        signUpPage.inPutData(firstName, lastName, email, password, phone , monthBirth, dayBirth, yearBirth);
      /*  signUpPage.errorMessages();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.errorMessages(), "This email address is not available for sign up, try something else");
        softAssert.assertEquals(signUpPage.errorMessages(), "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(signUpPage.errorMessages(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(signUpPage.errorMessages(), "That doesn’t look right, please re-enter your birthday.");

        softAssert.assertAll();*/

    }

}
