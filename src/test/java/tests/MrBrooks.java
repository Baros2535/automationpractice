package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class MrBrooks {
    WebDriver driver;
   @BeforeMethod
    public void start(){

       driver= WebDriverFactory.getDriver ( "chrome" );
   }
   @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep ( 3000 );
       driver.quit ();
   }
    @Test
    public void printedDress4th() throws InterruptedException {
       driver.get ( "http://automationpractice.com/index.php" );

        Actions builder= new Actions ( driver );
        WebElement hoverElement = driver.findElement ( By.xpath ( "(//div/a/img)[6] " ));
                builder.moveToElement ( hoverElement ).perform ();
       driver.findElement ( By.cssSelector ( "#homefeatured [data-id-product='4'] > span" ) ).click ();
        Thread.sleep ( 2000 );
       driver.findElement ( By.xpath ( "(//div/a/span)[6]" ) ).click ();

      // String expected = driver.findElement ( By.xpath ( "(//div/span)[16]" ) ).getText ();
        String expected = "$52.99";
        System.out.println (expected);

        String actual =driver.findElement ( By.xpath ( "(//tr/td)[11]" ) ).getText ();
        System.out.println (actual);

        Assert.assertEquals ( actual,expected,"verify they are equal??" );

        driver.findElement ( By.xpath ( "(//p/a/span)[2]" ) ).click ();




    }


}
