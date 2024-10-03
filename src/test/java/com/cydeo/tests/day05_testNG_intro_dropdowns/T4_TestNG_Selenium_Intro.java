package com.cydeo.tests.day05_testNG_intro_dropdowns;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //C #4: Cydeo Title Verification
        //1.Open Chrome browser
        //2.Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    @Test
    public void test1_cydeo_title_verification(){



        //3.Verify title:
        //Expected: Cydeo
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dropdowns";

        Assert.assertEquals(actualTitle,expectedTitle);



    }

}
