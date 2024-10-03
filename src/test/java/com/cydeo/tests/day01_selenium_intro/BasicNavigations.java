package com.cydeo.tests.day01_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //Create instance of Chrome browser
        WebDriver driver = new ChromeDriver(); // import otomatik yapiyor istemiyorsan pluginde -> General->auto importtan kapatabilirsin.(add,optimeze tikleri kapat)

        //Maximize the window
        driver.manage().window().maximize();


        //Go to audi
        driver.get("https://www.tesla.com/");


        //use .getCurrentUrl method to printout current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);


        //Use navigate back() to go back
        driver.navigate().back();


        //Stop execution for 3 seconds
        Thread.sleep(1000);


        //User navigate forward() to go forward
        driver.navigate().forward();

        //Stop execution for 3 seconds
        Thread.sleep(1000);


        //User refreshes the page using navigate.refresh();
        driver.navigate().refresh();


        //Stop execution for 3 seconds
        Thread.sleep(1000);


        //navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com/");

        //use .getCurrentUrl method to printout current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle = driver.getTitle(); // we reassign value .we do not need to write currentTitle2
        System.out.println("currentTitle = " + currentTitle);

        //closes only the currently focused window/tab
        driver.close();

        //closes all-of-the opened browsers
        driver.quit();

    /*
    driver.get(url)--> navigates to website
    driver.navigate().to(url)-->navigates to website
    //There is no difference

    driver.navigate().back()--> goes back previuos website
    driver.navigate().forward()--> goes forward after goes back
    driver.navigate().refresh()--> refresh the page

    */


    }
}
