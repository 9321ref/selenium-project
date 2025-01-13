package com.cydeo.tests.review.day8_9_10;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99_UploadTest {

    @Test
    public void upload_test(){
        // TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.upload.url"));

        //2. Upload file into Choose File
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\hasan\\Downloads\\some-file.txt");

        //3. Click terms of service check box
        Driver.getDriver().findElement(By.id("terms")).click();

        //4. Click Submit File button
        Driver.getDriver().findElement(By.id("submitbutton")).click();

        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded.
        WebElement resultMsg = Driver.getDriver().findElement(By.cssSelector("h3[id='res']>center"));
        BrowserUtils.sleep(3);

        String expectedMsg = "1 file\nhas been successfully uploaded.";
        String actualMsg = resultMsg.getText();

        Assert.assertEquals(actualMsg,expectedMsg,"Text verification is failed!");

    }
}






