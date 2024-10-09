package com.cydeo.tests.Selenium_Live_Lab.week20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackHiddenPassword {
    public static void main(String[] args) {

        //1- Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click LOGIN button
        driver.findElement(By.xpath("//a[@href='http://app.vytrack.com']")).click();

        // 4- Verify the password is hidden

        WebElement passwordInput = driver.findElement(By.cssSelector("input#prependedInput2"));

        String actualHiddenPass = passwordInput.getAttribute("type");
        String expectedHiddenPass = "password";

        if (actualHiddenPass.equals(expectedHiddenPass)){
            System.out.println("Password is hidden!");
        }else{
            System.out.println("Password is not hidden!");
        }

        driver.quit();






    }
}
