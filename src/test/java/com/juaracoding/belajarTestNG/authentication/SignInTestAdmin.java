package com.juaracoding.belajarTestNG.authentication;

import com.juaracoding.belajarTestNG.drivers.DriverSingleton;
import com.juaracoding.belajarTestNG.drivers.utils.BrowserType;
import com.juaracoding.belajarTestNG.pages.authentications.DashboardPage;
import com.juaracoding.belajarTestNG.pages.authentications.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTestAdmin {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;


    // Siapkan driver
    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

    // Tes login admin
    @Test
    public void signInTest() {
        driver.get("http://localhost:8000/admin");
        signInPage = new SignInPage(driver);
        signInPage.loginActivity("admin", "123qwe");

        dashboardPage = new DashboardPage(driver);

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = dashboardPage.getTextWelocmeHeadingElement();

        // Assert.assertTrue(actual.toLowerCase().equals(expected.toLowerCase()));
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }

    // Tutup driver agar bisa sign in lagi di class lain
    @AfterClass
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}
