package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class Baroreis {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
   driver = WebDriverFactory.getDriver("chorome");
   driver.manage().window().maximize();


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();


    }
    @Test
    public void test1(){
      // 1. Got to http://automationpractice.com/index.php

      // 2. Click your item Add to chart

      // 3. Click Proceed to checkout

      // 4. Assert popup page’s total to checkout page’s total amount

      // 5. Click proceed to checkout


    }

}
