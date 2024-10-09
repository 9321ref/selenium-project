package com.cydeo.tests.review.day5_6_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandleTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void window_handle_test(){
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
        driver.findElement(By.id("tabButtonWrapper")).click();

        //    4. Click on New Window button
        driver.findElement(By.id("windowButton")).click();

        //    5. Click on New Window Message button
        driver.findElement(By.id("messageWindowButton"));

        //    6. Print out each window title

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            System.out.println("eachWindow = " + eachWindow);
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
