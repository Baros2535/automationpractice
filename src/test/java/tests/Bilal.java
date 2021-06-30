package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class Bilal {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //Got to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");

        //Click your item Add to chart
        WebElement addToChart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span"));
        addToChart.click();
        Thread.sleep(3000);

        String popupTotal = driver.findElement(By.xpath("//*[@class=\"ajax_block_cart_total\"]")).getText();
        System.out.println("popupTotal = " + popupTotal);

        //Click Proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        Thread.sleep(3000);

        String checkoutTotal = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();
        System.out.println("checkoutTotal = " + checkoutTotal);

        //Assert popup page’s total to checkout page’s total amount
        Assert.assertEquals(popupTotal,checkoutTotal,"Verifying prices");

        //Click proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();


    }

}
