package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebOrderUtils {

//
//    public static String returnOrderDate(WebDriver driver, String customerName){
//
//        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";
//
//        WebElement customerDateCell = driver.findElement(By.xpath(locator));
//
//        return customerDateCell.getText();
//
//    }
    // same method as above, but just in 1 line.
    public static String returnOrderDate(WebDriver driver, String costumerName){

        return driver.findElement(By.xpath("//td[.='"+costumerName+"']/following-sibling::td[3]")).getText();

    }



    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate) {

        String locator = "//td[.='"+costumerName+"']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();


    }
}

/*
TC #2: Web table practice Task1 cont.

1. Create a new class called WebTableUtils.
2. Create two methods to verify order
Method #1 info:

• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String costumerName
This method should accept a costumerName and return the costumer order date
as a String.
 */