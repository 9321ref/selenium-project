package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set-ups /open browser
        //2. Go to website:  https://practice.cydeo.com/iframe
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://practice.cydeo.com/iframe");
    }


    @Test
    public void iframe_test(){

        //TC #4: Iframe practice

        //we have to switch to iframe to be to locate the web elements in there.

        //option#1- switch "id" attribute value
        //driver.switchTo().frame("mce_0_ifr"); // web elementleri bulmak icin iframe'e gecmek lazim.direk webelement locate ederek ypinca nosuchasaelement hatasi verr

        //option#2- switch using "index" number
        //driver.switchTo().frame(0); //sayfada inspect yapip //iframe dye yazinca kac tane ciktiysa ve kacinci iframe istiyrsan onun index yazarsin

        //option#3- switch using WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));


        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(paragraphText.isDisplayed());


        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame(); // bu text ana html old icin parentframe methodunu kullandik.yukarda ki bi alt html de 'Your content goes here.'
        //driver.switchTo().defaultContent();
        WebElement h3 = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(h3.isDisplayed());



    }
}
