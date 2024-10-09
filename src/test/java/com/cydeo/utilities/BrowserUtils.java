package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
   This class will be storing only the utility methods that can be used across the project
    */
public class BrowserUtils {

    public static void sleep(int second){

        /*
        This method will accept int (in seconds)
        and execute Thread.sleep method for given duration
        Arg: int second
         */
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e) {

        }
    }


    public static void switchWindowAndVerify(WebDriver driver ,String expectedInURL,String expectedInTitle){

        //Return and store all window handles in a Set
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles ) {

            driver.switchTo().window(each);
            System.out.println("Current Url: = " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)) {
                break; // stop immediately
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));



    }


    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle); //getTitle -> actualTitle

    }


    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle)); //getTitle -> actualTitle

    }
}


/*
TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
 */

/*
TC #3: Create utility method
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title
Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle
 */