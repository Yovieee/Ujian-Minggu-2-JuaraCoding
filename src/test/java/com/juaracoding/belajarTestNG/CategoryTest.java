package com.juaracoding.belajarTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.juaracoding.belajarTestNG.drivers.DriverSingleton;
import com.juaracoding.belajarTestNG.drivers.utils.BrowserType;
import com.juaracoding.belajarTestNG.pages.authentications.DashboardPage;
import com.juaracoding.belajarTestNG.pages.authentications.SignInPage;

public class CategoryTest {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;

    // Siapkan driver karena saat ini driver sedang null
    @BeforeClass
    public void setup() {
        DriverSingleton.getDriver(BrowserType.FIREFOX);
    }

    // Tes penambahan kategori dengan mengisi nilai inputan
    @Test(priority = 1)
    public void addCategoryPositiveTest() {
        DriverSingleton.driver.get("http://localhost:8000/admin");
        signInPage = new SignInPage(DriverSingleton.driver);
        signInPage.loginActivity("admin", "123qwe");

        dashboardPage = new DashboardPage(DriverSingleton.driver);
        dashboardPage.clickAddCategoryButtonElement();

        int random = (int) (Math.random() * 1000);

        DriverSingleton.driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Tes Kategori" + random);
        DriverSingleton.driver.findElement(By.xpath("//input[@name='_save']")).click();

        String expected = "Tes Kategori" + random;
        String actual = DriverSingleton.driver
                .findElement(By.xpath("//th[@class='field-name']//a[contains(text(),'" + expected + "')]")).getText();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }

    // Tes penambahan kategori dengan membiarkan nilai inputan kosong
    @Test(priority = 2)
    public void addCategoryNegativeTest() {
        DriverSingleton.driver.findElement(By.xpath("//a[normalize-space()='Home']"));

        dashboardPage = new DashboardPage(DriverSingleton.driver);
        dashboardPage.clickAddCategoryButtonElement();

        DriverSingleton.driver.findElement(By.xpath("//input[@name='_save']")).click();

        String expected = "Please correct the error below.";
        String actual = DriverSingleton.driver.findElement(By.xpath("//p[@class='errornote']")).getText();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }
}
