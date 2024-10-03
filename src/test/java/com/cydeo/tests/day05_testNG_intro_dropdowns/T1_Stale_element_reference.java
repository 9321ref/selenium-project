package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class T1_Stale_element_reference {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(xpath("//button[.='Add Element']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed(), expecting true = " + deleteButton.isDisplayed());


        //5. Click to “Delete” button.
        Thread.sleep(3000);
        deleteButton.click();


        //6. Verify “Delete” button is NOT displayed after clicking.
        //use try catch to handle and verify

        try {
            System.out.println("deleteButton.isDisplayed() , expecting false = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e) {
            System.out.println("-->StaleElementReferenceException happened due to element being deleted form the page.");
            System.out.println("which concludes our test case -PASSING!-");
            System.out.println("deleteButton.isDisplayed() = false" );
        }








    }

}

