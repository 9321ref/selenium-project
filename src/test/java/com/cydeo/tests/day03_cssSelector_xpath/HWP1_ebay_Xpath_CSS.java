package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP1_ebay_Xpath_CSS {
    public static void main(String[] args) {

        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2. Go to https://www.google.com
        driver.get("https://www.amazon.com");


        //3. Search for “wooden spoon”
        //    tagName[@attribute='value']
        //   input[@type='text']
        WebElement searchBox = driver.findElement(By.xpath("input[@type='text']"));

        searchBox.sendKeys("wooden Spoon");
        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”
    }
}
