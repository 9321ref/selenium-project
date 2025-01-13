package com.cydeo.tests.review.day8_9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTablePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void web_table_practice(){
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("table1 = " + table1.getText());// as a string istedigi icin getText()


        // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        // 5. print all column names in single line
        WebElement allColumnNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr")); // -> index bulunusu ama tercih etmeyn (//table[@id='table1']//tr)[1]
        //table1 = Last Name First Name Email Due Web Site Action

        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> allColumnSeparate = driver.findElements(By.xpath("//table[@id='table1']//th")); // elements provide List<>

       for (WebElement eachColm : allColumnSeparate) {
           System.out.println("eachColm = " + eachColm.getText());
       }

        // 7. verify Tim due money is $50.00

         /*
        When you locate an element in web-table;
        Step 1: we have to determine unique test data //table[@id='table1']//td[.='tconway@earthlink.net']
        Step 2: we will go through a wanted element using siblings or parent/child ways
         */
        //WebElement timDue$50 = driver.findElement(By.xpath("//table[@id='table1']//td[.='tconway@earthlink.net']/following-sibling::td[.='$50.00']"));
        WebElement timDue$50 = driver.findElement(By.xpath("//table[@id='table1']//td[.='tconway@earthlink.net']/../td[4]")); //first locate the unique data 'email' then go parent and locate what you need
                                                                                                                                              //-> go from the child to parent/..
        Assert.assertEquals(timDue$50.getText(),"$50.00");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
