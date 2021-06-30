package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class Baroreis {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
   driver = WebDriverFactory.getDriver("chrome");


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();


    }
    @Test
    public void test1() throws InterruptedException {
      // 1. Got to http://automationpractice.com/index.php
    driver.get("http://automationpractice.com/index.php");
    Thread.sleep(6000);
      // 2. Click your item Add to chart
        System.out.println("sayfaya girildi");
    driver.findElement(By.xpath("(//a[@class=\"product_img_link\"])[3]")).click();
        System.out.println("resim tıklandı");

        Thread.sleep(5000);

  driver.findElement(By.xpath("//div/a[@title=\"Close\"]")).click();
        Thread.sleep(300000);
 driver.findElement(By.xpath("(//div[@class=\"button-container\"])[4]")).click();
        System.out.println("sepete eklendi");

        // 3. Assert popup page’s total to checkout page’s total amount
        Thread.sleep(3000);
        String expectedPrice = driver.findElement(By.xpath("//div/span[@class=\"ajax_block_cart_total\"]")).getText();
        System.out.println(expectedPrice);

      // 4. Click Proceed to checkout
        Thread.sleep(12000);
    driver.findElement(By.xpath("//a[contains(@title,\"Proceed to checkout\")]")).click();
Thread.sleep(3000);
        // 5. Click proceed to checkout

        String actualPrice = driver.findElement(By.cssSelector("#total_price_without_tax")).getText();
Thread.sleep(3000);
        Assert.assertEquals(actualPrice,expectedPrice,"Verifying prices");

        //driver.findElement(By.xpath("//div/a[contains(@title,\"Proceed to checkout\")]")).click();


    }

}