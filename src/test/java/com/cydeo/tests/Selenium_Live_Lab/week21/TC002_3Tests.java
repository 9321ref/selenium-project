package com.cydeo.tests.Selenium_Live_Lab.week21;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC002_3Tests {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        //TC002 As a user I should be able to select Alabama
        //  1-Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
    }


    @Test
    public void dropdownTest(){
        //  3-click Dropdown
        driver.findElement(By.linkText("Dropdown")).click();

        //  4-select Alabama from the State Selection dropdown menu
        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("Alabama");
        //selectState.selectByValue("AL");

        //  5-verify Alabama is selected
        String expectedSelectedOption = "Alabama";
        String actualSelectedOption = selectState.getFirstSelectedOption().getText();

        System.out.println("actualSelectedOption = " + actualSelectedOption);
        System.out.println("expectedSelectedOption = " + expectedSelectedOption);

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption,"Verification is not pass");

        driver.quit();
    }

    @Test
    public void radioButtonTest(){
        //TC003 As a user I should be able to select my favorite color and sport
        //  3-click Radio Buttons
        //driver.findElement(By.linkText("Radio Buttons")).click();
        BrowserUtils.clickOption(driver,"Radio Buttons"); //utility classtan bu methodla click yapilabilir

        //  4-verify title contains Radio buttons
        BrowserUtils.verifyTitleContains(driver,"Radio buttons");

        //  5-select the favorite color as Red
        WebElement red = driver.findElement(By.id("red"));
        red.click();

        //  6-verify the Red is selected
        Assert.assertTrue(red.isSelected());

        //  7-select the favorite sport as Football
        WebElement footballButton = driver.findElement(By.id("football"));
        footballButton.click();

        //  8-verify the Football is selected
        Assert.assertTrue(footballButton.isSelected());

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
