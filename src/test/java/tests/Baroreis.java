package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Baroreis {
    WebDriver driver;
    Wait wait;
    @BeforeMethod
    public void setUp(){
   driver = WebDriverFactory.getDriver("CHROME");
   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
       /* Wait <WebDriver> wait = new FluentWait <WebDriver> (driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);*/

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

        // 2. Click your item Add to chart
        Actions builder = new Actions(driver);
        WebElement hoverElement= driver.findElement(By.xpath("(//a[@class=\"product_img_link\"])[3]"));
        builder.moveToElement(hoverElement).perform();
        driver.findElement(By.xpath("(//div[@class=\"button-container\"])[4]")).click();

        // 3. Assert popup page’s total to checkout page’s total amount

      Thread.sleep(15000);
       // String expectedPrice = driver.findElement(By.xpath("((//div/span)[14]")).getText();
     //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,\"Proceed to checkout\")]")));
      //  System.out.println(expectedPrice+ " bulunamadı");
        String expectedPrice="$28.00";
        // 4. Click Proceed to checkout

        driver.findElement(By.xpath("//a[contains(@title,\"Proceed to checkout\")]")).click();

        // 5. Click proceed to checkout

        String actualPrice = driver.findElement(By.cssSelector("#total_price_without_tax")).getText();

        Assert.assertEquals(actualPrice,expectedPrice,"Verifying prices");

        //driver.findElement(By.xpath("//div/a[contains(@title,\"Proceed to checkout\")]")).click();


    }


}
