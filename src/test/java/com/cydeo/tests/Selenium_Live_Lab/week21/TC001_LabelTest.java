package com.cydeo.tests.Selenium_Live_Lab.week21;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC001_LabelTest {

    public static void main(String[] args) {

        //Topics:
        //      ** findElements() -TestNG - Dropdown - Radio Button - Utility
        //==========================================

        //TC001 As a user I should be able to see Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed

        //  1-Open a Chrome browser
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are displayed
        List<String> expectedLabelTexts = new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));

        List<WebElement> actualLabels = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a")); //locate all web elements. we do all elements just one xpath.we found first parent
        // and then go through in child and access 6 elements at the same time

        List<String> actualLabelsTexts = new ArrayList<>();

        for (WebElement each : actualLabels) {
            actualLabelsTexts.add(each.getText());
        }
            if (actualLabelsTexts.equals(expectedLabelTexts)) {
                System.out.println(" Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are displayed");
            } else {
                System.out.println(" Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are NOT displayed");
            }

            driver.quit();

        }
    }


