package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import javax.jws.WebService;

public class HsnZts {

    /*
    1. Go to http://automationpractice.com/index.php
    2. Click your item Add to chart
    3. Click Proceed to checkout
    4. Assert popup page’s total to checkout page’s total amount
    5. Click proceed to checkout
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }


}
