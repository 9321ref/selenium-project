package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Google_Search {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #1: Google search
        //1- Open a Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));

    }
    @Test
    public void google_search_test(){
        //3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search     search word does not change
        // Expected: flowers - Search
        String actualTitle = driver.getTitle();

        //String expectedTitle = " apple - Google Suche";
        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google Suche";
        BrowserUtils.sleep(2);

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

}
