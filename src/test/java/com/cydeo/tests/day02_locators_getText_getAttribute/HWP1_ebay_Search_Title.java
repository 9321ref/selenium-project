package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_ebay_Search_Title {
    public static void main(String[] args) {

        //HWP #1: ebay Title Verification
        //1. Open Chrome browser
        //Creating a new ChromeDriver and storing in it "driver"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.ebay.com
        driver.get("https://www.ebay.com");

        //3. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        searchBox.sendKeys("wooden spoon" + Keys.ENTER);


        //4. Verify title:
        //Expected: “Wooden spoon - ebay”
        String expectedTitle = "Wooden spoon - ebay";
        String actualTitle = driver.getTitle();

        //crete a simple if condition to compare our actual and expected titles
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("ebay title verification Passed!");
        }else{
            System.out.println("ebay title verification Failed!");
        }

        //close the browser
        driver.close();
    }
}
