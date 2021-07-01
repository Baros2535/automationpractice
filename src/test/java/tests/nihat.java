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

import java.util.concurrent.TimeUnit;

public class nihat {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get ( "http://automationpractice.com/index.php" );

        Actions builder= new Actions ( driver );
        WebElement hoverElement = driver.findElement ( By.xpath ( "(//div/a/img)[6] " ));
        builder.moveToElement ( hoverElement ).perform ();

        //add to chart
        driver.findElement ( By.xpath ( "(//div[@class='button-container']/a)[8]" ) ).click ();

        //innerText
        WebElement expected1 = driver.findElement( By.xpath ( "//div[@class='layer_cart_row'][3]/span" ) );

        Thread.sleep(3000);
        String expected = expected1.getAttribute("innerText");


        System.out.println(expected);

        //proceed to checkout
        driver.findElement ( By.xpath ( "(//div/a/span)[6]" ) ).click ();

        String actual =driver.findElement ( By.xpath ( "(//tr/td)[11]" ) ).getText ();
        System.out.println (actual);

        Assert.assertEquals ( actual,expected,"verify they are equal??" );

        //driver.findElement ( By.xpath ( "(//p/a/span)[2]" ) ).click ();




    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }








}
