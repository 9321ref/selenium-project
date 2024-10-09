package com.cydeo.tests.review.day5_6_7;

import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void iframeTest(){
        // TC : Iframe practice
        // 1. Users are already login and on the homepage of CRM app (You can use CRM_Utilities class)
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);

        // 2. Users click the MESSAGE tab
        driver.findElement(By.xpath("//span[text()='Message']")).click();

        // 3. Users write test message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.tagName("body")).sendKeys("staleElement");

        // 4. Users click the SEND button
        driver.switchTo().parentFrame(); // It takes to parent iframe if there is nested iframe. if not, it will take main HTML
        driver.switchTo().defaultContent();//it takes directly to Main HTML
        driver.findElement(By.id("blog-submit-button-save")).click();

        // 5. Verify the message is displayed on the feed
        WebElement feedMsg = driver.findElement(By.xpath("//div[contains(@id,'blog_post_body_')]"));

        Assert.assertEquals(feedMsg.getText(),"staleElement");
    }

/*
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


 */



}
