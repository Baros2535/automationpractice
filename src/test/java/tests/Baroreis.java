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

    }

}
