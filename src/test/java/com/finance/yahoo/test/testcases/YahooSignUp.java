package com.finance.yahoo.test.testcases;

import com.finance.yahoo.pages.HomePage;
import com.finance.yahoo.pages.SignInPage;
import com.finance.yahoo.pages.SignUpPage;
import com.finance.yahoo.test.base.TestUtil;
import com.finance.yahoo.util.CsvReader;
import com.opencsv.exceptions.CsvException;
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
        signUpPage.setFirstName(firstName);
        signUpPage.setLastName(lastName);
        signUpPage.setEmail(email);
        signUpPage.setPassword(password);
        signUpPage.setPhone(phone);
        signUpPage.setBirthData(monthBirth, dayBirth, yearBirth);
        signUpPage.clickRegistration();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.getEmailValidationMessage(), "This email address is not available for sign up, try something else");
        softAssert.assertEquals(signUpPage.getPasswordValidationMessage(), "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(signUpPage.getPhoneValidationMessage(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(signUpPage.getBirthDayValidationMessage(), "That doesn’t look right, please re-enter your birthday.");

        softAssert.assertAll();

    }

}
