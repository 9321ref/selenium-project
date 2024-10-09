package com.cydeo.tests.day08_properties_config_reader;

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

public class T4_use_config_reader {
    
    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. Search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.



    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //Create new test and make setups
        //1- Open a Chrome browser
        //2- Go to: https://google.com
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigurationReader.getProperty("googleURL"));
    }


    @Test
    public void google_search_test(){

        //3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Suche

        //String expectedTitle = "apple - Penelusuran Google";
         String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Penelusuran Google";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);





    }
}
