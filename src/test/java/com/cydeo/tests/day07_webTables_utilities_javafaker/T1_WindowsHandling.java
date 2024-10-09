package com.cydeo.tests.day07_webTables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set-ups
        //2. Go to : https://www.amazon.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://www.amazon.com");
    }


    @Test
    public void window_handling_test1(){
         //TC #1: Window Handle practice

        //3. Copy and paste the lines from below into your class(downcasting yaptik)
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        //Return and store all window handles in a Set
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles ) {

            driver.switchTo().window(each);
            System.out.println("Current Url: = " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")) {
                break; // stop immediately
            }
        }

//        //5. Assert: Title contains “Etsy”
//        String actualTitle = driver.getTitle();
//        String expectedInTitle = "etsy";
//
//        Assert.assertTrue(actualTitle.contains(expectedInTitle));

//  INSTEAD OF THe ABOVE:
        BrowserUtils.verifyTitleContains(driver,"etsy");






    }



    @Test
    public void window_handling_test2(){
        //TC #1: Window Handle practice

        //3. Copy and paste the lines from below into your class(downcasting yaptik)
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver,"etsy","etsy");


    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.quit();
    }




}
