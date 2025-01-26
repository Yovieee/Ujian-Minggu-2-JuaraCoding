package com.juaracoding.belajarTestNG.drivers.strategies;

import com.juaracoding.belajarTestNG.drivers.managers.ChromeDriverManager;
import com.juaracoding.belajarTestNG.drivers.managers.FirefoxDriverManager;
import com.juaracoding.belajarTestNG.drivers.utils.BrowserType;

import org.openqa.selenium.WebDriver;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}
