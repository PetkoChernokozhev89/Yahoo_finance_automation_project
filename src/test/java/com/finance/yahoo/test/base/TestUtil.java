package com.finance.yahoo.test.base;

import com.finance.yahoo.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

        public WebDriver driver;
        private String url;
        private int implicitWait;
        public String browser;

    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {
        driver.manage().window().maximize();
        driver.get(url);
    }

    private void setupBrowserDriver() {
        try (
                FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("This browser is not supported");


        }


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
