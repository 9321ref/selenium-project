package com.cydeo.tests.review.day1_2_3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticePageLogin {
    public static void main(String[] args) throws InterruptedException {

        // TC#2: Practice page Login test

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/login");


        // 3. Enter username: "tomsmith" (name locator )
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword" (xpath locator)
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword"); //xpath kullanirsak her istedigin elementi kullanabilirsin.tagName olarak name kullansaydik sadce name de olan value olurdu yani 'password'


        // 5. Click to Log-in button
        driver.findElement(By.id("wooden_spoon")).click();
       // driver.findElement(By.className("btn btn-primary")); //this is special only for className -does not accept space.space means there is two class.that is why doesn't work locator

        Thread.sleep(3000);

        // 6. Verify text displayed on page contains
        //    Expected: "You logged into a secure area!"
        //WebElement msg1 = driver.findElement(By.id("flash"));
       // WebElement msg2 = driver.findElement(By.className("flash success")); // doesn't work because there is space.you can use instead of it xpath or css locator
        WebElement msg3 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
       // WebElement msg4 = driver.findElement(By.cssSelector("div#flash")); //# css icin kullanilir
       // WebElement msg5 = driver.findElement(By.xpath("//div[@id='flash']"));


        String expectedMsg = "You logged into a secure area!";
        String actualMsg = msg3.getText();

        if(actualMsg.contains(expectedMsg)) {
            System.out.println("Message verification passed");
        }else {
            System.out.println("Message verification failed");
        }

        driver.quit();
        //CSS cannot locate elements using text
        //i can not go form child to parent with css locator,but xpath can

        //xpath:
        //  -> //div[normalize-space(text())='...text...']  bu method eger textin basinda white space varsa onu kaldirmak icin .
        //div[text()='You logged into a secure area!'] -> bu sekilde yaizinca bulamiyor locate old yeri.metinden önce white sapce var
    }
}
