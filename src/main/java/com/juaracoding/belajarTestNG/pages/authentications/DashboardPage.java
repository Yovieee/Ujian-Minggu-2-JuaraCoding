package com.juaracoding.belajarTestNG.pages.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Welcome to Demo SQA Testing Portal']")
    private WebElement welcomeHeadingElement;

    private WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void waitForWelcomeHeadingElement() {
        By locator = By.xpath("//h1[normalize-space()='Welcome to Demo SQA Testing Portal']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getTextWelocmeHeadingElement() {
        waitForWelcomeHeadingElement();
        return welcomeHeadingElement.getText();
    }

    public void waitForAddCategoryButtonElement() {
        By locator = By.xpath("//a[@href='/admin/products/category/add/']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickAddCategoryButtonElement() {
        waitForAddCategoryButtonElement();
        driver.findElement(By.xpath("//a[@href='/admin/products/category/add/']")).click();
    }
}
