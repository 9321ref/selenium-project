package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void uploading_test(){
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\hasan\\Desktop\\Day 8 Class Notes.txt";

        //3. Upload the file.Use sendKeys() method and pass the "path" as a String.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);

        //This is the line that is passing the path of the file to the website
        chooseFileButton.sendKeys(path);
        //chooseFileButton.sendKeys("C:\\Users\\hasan\\Desktop\\Day 8 Class Notes.txt"); you can write instead of line 19

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(),"Header text is not displayed");


        //File uploaded text is displayed on the page



    }
}
