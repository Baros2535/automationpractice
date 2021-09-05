package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class Team1TestCase1_Erhan {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }
    @Test
    public void openBrowser() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//ul[@id='homefeatured']/li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//span[.='Add to cart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

        String popupPrice = driver.findElement(By.xpath("(//*[text() = '$18.51'])[2]")).getText();

        String checkoutPrice = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();

        Assert.assertEquals(popupPrice,checkoutPrice,"verify text is same");

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

    }


}
