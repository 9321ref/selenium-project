package com.cydeo.tests.review.day1_2_3_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistrationForm {
    public static void main(String[] args) {


        // TC#3: Registration Form Page Testing

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/registration_form");


        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        if(driver.getTitle().equals("Registration Form")) {
            System.out.println("Title verification is passed");
        }else {
            System.out.println("Title verification is failed");
        }

    }
}
