package com.cydeo.tests.review.day1_2_3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RegistrationFormFilling {
    public static void main(String[] args) throws InterruptedException {


        // TC#4: Registration Form Page Filling Form Test

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        driver.findElement(By.cssSelector("input[placeholder='first name']")); // css locator da her attribute secebiliriz ama unique veya first maching olmasi lazim

        // 4. Enter Last name: "Smith"
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]")); //html de bir cok class cikti ve specifiklestirmek icin index num yazdik[2]

        // 5. Enter Username: "johnsmith123"
        driver.findElement(By.xpath("(//form[@id='registrationForm'])//div/input[@name='username']")).sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        driver.findElement(By.name("email")).sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("John1234");


        // 8. Enter Phone number: "123-456-7890"
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("123-456-7890");


        // 9. Click to "Male" from Gender
        driver.findElement(By.xpath("//input[@value='male']")).click();

        // 10. Enter Date of birth "01/28/1990"
        driver.findElement(By.name("birthday")).sendKeys("01/28/1990");

        // 11. Click to "Java" from languages
        driver.findElement(By.id("inlineCheckbox2")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));// bir cok tiklamali yer varsa ve hepsnie tiklayacaksan,ortak olan elementi seceresen hepsi tik olur

        for(WebElement each : checkboxes) {
            each.click();
            Thread.sleep(3000);
        }

        driver.quit();


    }
}
