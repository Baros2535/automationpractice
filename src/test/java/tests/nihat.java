package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
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

    @Test
    public void test2(){

        driver.get ( "http://automationpractice.com/index.php" );

        //hover on the image to get visible add chart icon
        Actions builder= new Actions ( driver );
        WebElement hoverElement = driver.findElement ( By.xpath ( "(//div/a/img)[6] " ));
        builder.moveToElement ( hoverElement ).perform ();

        //add to chart
        driver.findElement ( By.xpath ( "(//div[@class='button-container']/a)[8]" ) ).click ();

        //proceed to checkout
        driver.findElement ( By.xpath ( "(//div/a/span)[6]" ) ).click ();

        //proceed to checkout
        driver.findElement(By.xpath("(//p/a/span)[2]")).click();

        //write email into emailbox
        driver.findElement(By.xpath("(//div/input)[1]")).sendKeys("nihatgokay@gmail.com");

        //click create account
        driver.findElement(By.cssSelector( "#SubmitCreate>span")).click();

        //click gender
        driver.findElement(By.cssSelector("#id_gender1")).click();

        //send some info name&surname&password
        driver.findElement(By.id("customer_firstname")).sendKeys("Nihat Gokay");
        driver.findElement(By.id("customer_lastname")).sendKeys("YUZBASIOGLU");
        driver.findElement(By.id("passwd")).sendKeys("243406");

        //select day of birth date
        WebElement dropdown = driver.findElement(By.id("days"));
        Select dateDropdown = new Select(dropdown);
        List<WebElement>options =dateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());
        dateDropdown.selectByIndex(26);

        //select month of birth date
        WebElement dropdown1 = driver.findElement(By.id("months"));
        Select dateDropdown1 = new Select(dropdown1);
        List<WebElement>options1 =dateDropdown1.getOptions();
        System.out.println("options.size() = " + options1.size());
        dateDropdown1.selectByIndex(4);

        //select year of birth date
        WebElement dropdown2 = driver.findElement(By.id("years"));
        Select dateDropdown2 = new Select(dropdown2);
        List<WebElement>options2 =dateDropdown2.getOptions();
        System.out.println("options.size() = " + options2.size());
        dateDropdown2.selectByValue("1989");

        //write address
        driver.findElement(By.xpath("(//div/p/input)[1]")).sendKeys("Nihat Gokay");
        driver.findElement(By.xpath("(//div/p/input)[2]")).sendKeys("YUZBASIOGLU");
        driver.findElement(By.xpath("(//div/p/input)[3]")).sendKeys("Cybertek");
        driver.findElement(By.xpath("(//div/p/input)[4]")).sendKeys("Homeless");
        driver.findElement(By.xpath("(//div/p/input)[5]")).sendKeys("Everywhere");
        driver.findElement(By.xpath("(//div/p/input)[6]")).sendKeys("Istanbul");

        //select state without select tag
        WebElement dropdown3 = driver.findElement(By.id("id_state"));
        Select stateDropdown = new Select(dropdown3);
        List<WebElement> options3 = stateDropdown.getOptions();
        stateDropdown.selectByVisibleText("Colorado");

        driver.findElement(By.xpath("(//div/p/input)[7]")).sendKeys("34528");
        driver.findElement(By.xpath("//div/p/textarea")).sendKeys("Successful");
        driver.findElement(By.xpath("(//div/p/input)[8]")).sendKeys("2128720545");
        driver.findElement(By.xpath("(//div/p/input)[9]")).sendKeys("5306001002");
        driver.findElement(By.xpath("(//div/p/input)[10]")).sendKeys("Village");

        //sign in
        driver.findElement(By.xpath("(//div/button/span)[1]")).click();

    }

    @Test
    public void test3(){

        driver.get ( "http://automationpractice.com/index.php" );

        //hover on the image to get visible add chart icon
        Actions builder= new Actions ( driver );
        WebElement hoverElement = driver.findElement ( By.xpath ( "(//div/a/img)[6] " ));
        builder.moveToElement ( hoverElement ).perform ();

        //add to chart
        driver.findElement ( By.xpath ( "(//div[@class='button-container']/a)[8]" ) ).click ();

        //proceed to checkout
        driver.findElement ( By.xpath ( "(//div/a/span)[6]" ) ).click ();

        //proceed to checkout
        driver.findElement(By.xpath("(//p/a/span)[2]")).click();

        //sign in data
        driver.findElement(By.id("email")).sendKeys("nihatgokay@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("243406");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        //comment box
        driver.findElement(By.xpath("//textarea")).sendKeys("done");

        //proceed to checkout
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//span")).click();

        //click terms
        driver.findElement(By.cssSelector("#cgv")).click();

        driver.findElement(By.xpath("(//div//button)[2]")).click();


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }








}
