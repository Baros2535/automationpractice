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

    @Test
    public void test1() throws InterruptedException {

        // 1. Go to http://automationpractice.com/index.php
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://automationpractice.com/index.php");

        Thread.sleep(2500);

        // 2. Click your item Add to chart
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span")).click();

        Thread.sleep(2500);

        // 3. Click Proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

        Thread.sleep(2500);

        // 4. Assert popup page’s total to checkout page’s total amount
        String popupTotal = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText();



        String checkoutTotal = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();

        Assert.assertEquals(popupTotal, checkoutTotal);

        Thread.sleep(2500);





    }
}
