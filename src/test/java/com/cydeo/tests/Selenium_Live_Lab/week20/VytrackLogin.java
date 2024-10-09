package com.cydeo.tests.Selenium_Live_Lab.week20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackLogin {
    public static void main(String[] args) throws InterruptedException {

        //** TC001 As a user I should be able to log in with valid credentials

        // 1- Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click LOGIN button
        WebElement logInBtn = driver.findElement(By.linkText("LOGIN")); //eger daha sonra bu kodu kullanacaksak webelemnt store ederiz
        //driver.findElement(By.linkText("LOGIN")); bu sekildede yazilabilr
        logInBtn.click();


        // 4- Login to application with username as "User1" and password as "UserUser123"
        driver.findElement(By.id("prependedInput")).sendKeys("User1" + Keys.ENTER); // id locator unique old icin en mantiklisi
        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(3000);


        //5- Verify the title is "Dashboard"
        if(driver.getTitle().equals("Dashboard")) {
            System.out.println("Title verification is Passed");
        }else{
            System.out.println("Title verification is Failed");
        }

        driver.quit();
    }
}
