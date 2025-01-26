package com.juaracoding.belajarTestNG;

import com.juaracoding.belajarTestNG.drivers.DriverSingleton;
import com.juaracoding.belajarTestNG.drivers.utils.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HookTest {

    @BeforeTest
    public void init() {
        System.out.println("init");
        DriverSingleton.getDriver(BrowserType.FIREFOX);
    }

    @AfterTest
    public void teardown() {
        System.out.println("teardown");
        DriverSingleton.quitDriver();
    }
}
