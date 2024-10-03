package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
    //  WebDriver driver = new ChromeDriver();
        WebDriver driver  = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Enter incorrect username: “incorrect”
        WebElement inputUsername = driver.findElement(By.className("login-inp"));
        inputUsername.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));// burada name ele aldik cünkü iki tane className alinca ilk sonucu yani üstteki classname alcak .
        inputPassword.sendKeys("incorrect");                       // bu nedenle ikincisinde name aldik locator olarak


        //5- Click to Log in button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText = "Incorrect login or password";

        String actualErrorText = driver.findElement(By.className("errortext")).getText(); // ***1


        if(actualErrorText.equals(expectedErrorText)){
            System.out.println("Error text verification Passed!");
        }else{
            System.out.println("Error text verification Failed!");
        }




        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
    }
}
