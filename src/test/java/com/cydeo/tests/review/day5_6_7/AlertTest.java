package com.cydeo.tests.review.day5_6_7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // TC : Alert practice
        // 1. Open browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void alert_test() throws InterruptedException {
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        // 3. Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // 4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();

        System.out.println("alert.getText() = " + alert.getText());

        alert.sendKeys("hello");// if you need to accept or cancel, you should choose those methods

        Thread.sleep(2000);

        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertEquals(resultText.getText(),"You entered: hello","Text verification is failed");
        
    }

    public void teardown(){
        driver.quit();
    }
}
