package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {

//    WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod(){
//        //TC #1: Google search
//        //1- Open a Chrome browser
//        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




    @Test
    public void google_search_test(){
        //2- Go to: https://google.com
        //Driver.getDriver() ---> will return me the "driver
        //instead of writing "driver" form now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));


        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search     search word does not change
        // Expected: flowers - Search
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();

        //String expectedTitle = " apple - Google Suche";
        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Penelusuran Google";


        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }


    @Test
    public void google_search_test2(){

        //2- Go to: https://google.com
        //Driver.getDriver() ---> will return me the "driver
        //instead of writing "driver" form now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));


        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search     search word does not change
        // Expected: flowers - Search
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();

        //String expectedTitle = " apple - Google Suche";
        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Penelusuran Google";


        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @AfterMethod
    public void tearDown(){

          /*
        We won't be using the selenium's quit method directly anymore.

        Driver.getDriver().quit(); --> no more using this method

        We will use Driver.closeDriver();
         */

        Driver.closeDriver();
    }

}


