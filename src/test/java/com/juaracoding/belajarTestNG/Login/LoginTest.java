package com.juaracoding.belajarTestNG.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private ChromeOptions options;

    @BeforeClass
    public void setup() {
        options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:8000/admin");
    }

    @Test
    public void loginTest() throws InterruptedException {
        WebElement fieldUsername = driver.findElement(By.id("id_username"));
        WebElement fieldPassword = driver.findElement(By.id("id_password"));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));

        TimeUnit.SECONDS.sleep(1);
        fieldUsername.sendKeys("admin");
        TimeUnit.SECONDS.sleep(1);
        fieldPassword.sendKeys("123qwe");
        TimeUnit.SECONDS.sleep(1);
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void closing() {
        if (driver != null) {
            driver.close();
        }
    }

}
