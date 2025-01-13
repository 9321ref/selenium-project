package com.cydeo.tests.review.day8_9_10;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Guru99_ActionsTest {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void actions_test(){
        // TC: Guru99 Drag and Drop Test
        // 1- Open a Chrome browser
        // 2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.drag.drop.url"));

        // 3- Drag “BANK” and drop into Account area under Debit Side
        WebElement bank = Driver.getDriver().findElement(By.linkText("BANK"));
        WebElement account = Driver.getDriver().findElement(By.id("bank"));

        actions.dragAndDrop(bank,account).perform();

        // 4- Drag “5000” and drop into Amount area under Debit Side
        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amount = Driver.getDriver().findElement((By.id("amt7")));

        actions.moveToElement(fiveK).clickAndHold().pause(2000).moveToElement(amount).release().perform(); //release button ele alinan elementi serrbest birakir

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
