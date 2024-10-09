package com.cydeo.tests.review.day5_6_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegistrationFormTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        // 1. Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
    }


    @Test
    public void registration_form_title(){
//        // 1. Open Chrome browser
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // 2. Go to https://practice.cydeo.com/registration_form
//        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        Assert.assertEquals(driver.getTitle(),"Registration Form","Title verification is failed!"); //message only comes if expected fail.

        driver.quit();
    }

    @Test
    public void registration_form_filling_test(){
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

        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select departmentSelect = new Select(driver.findElement(By.name("department")));
        //departmentSelect.selectByIndex(1);
        //departmentSelect.selectByValue("DE");
        departmentSelect.selectByVisibleText("Department of Engineerin"); // this one is safety and useful

        String expectedSelectedOption = "Department of Engineering";
        String actualSelectedOption = departmentSelect.getFirstSelectedOption().getText(); //GFSO is provided WebElement.but we store this method as a string gives error.that is why we need to use getText method,to store as a String

        //Assert.assertEquals(actualSelectedOption,expectedSelectedOption);  // Hard assertion will not execute next line of code if fail
        SoftAssert softAssert = new SoftAssert(); // Soft assert will execute next line of codes even it fails
        softAssert.assertEquals(actualSelectedOption,expectedSelectedOption);


        // 12. Select "SDET" from Job title dropdown
        Select jobSelect = new Select(driver.findElement(By.name("job_title")));
        System.out.println("jobSelect.getFirstSelectedOption().getText() = " + jobSelect.getFirstSelectedOption().getText());

        jobSelect.selectByVisibleText("SDET");

        Assert.assertEquals(jobSelect.getFirstSelectedOption().getText(),"SDE"); //short and easy way to write line 88,89
        softAssert.assertEquals(jobSelect.getFirstSelectedOption().getText(),"SDE");

        softAssert.assertAll();

        // 13. Click to "Java" from languages
        // 14. Click to "Sign up" button
        // 15. Verify text displayed on page
        //     Expected: "Well done!"

    }

    public void teardown(){
        driver.quit();
    }
}

