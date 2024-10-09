package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
   This class will store the method related to CRM project
   This method will log in using below credentials.
   @Username:
 */
public class CRM_Utilities {

    public static void login_crm(WebDriver driver){

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement inputPassWord = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassWord.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();


    }

    public static void login_crm(WebDriver driver, String username, String password){

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassWord = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassWord.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();


    }

}
/*
TC #5: Create utility method
1. Create a new method for login
2. Create a method to make Task3 logic re-usable
3. When method is called, it should simply log in

This method should have at least 2 overloaded versions.

Method #1 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver

Method #2 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
• Arg2: String username
• Arg3: String password
 */