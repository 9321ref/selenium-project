package com.cydeo.tests.review.day1_2_3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Navigations_GetMethods {
    public static void main(String[] args) throws InterruptedException {

        // TC#1: Navigations and Get methods Practice

        // 1. Open a Chrome browser
        // 2. Go to: https://practice.expandtesting.com/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicitlyWait works only for findElement(). eger element yoksa yada süre yeterli deilse NoSuchAsElement exception atar
        driver.get(" https://practice.expandtesting.com/");


        // 3. Click on "Automation Training"
        driver.findElement(By.linkText("Automation Training")).click(); //linkText tag use for just <a  'anchor tag'


        Thread.sleep(3000); //: Programı tamamen duraklatır, bu sürede başka hiçbir işlem yapılmaz.bundan snra gelen code donar
        //  you should close ad manually as soon as you see it.sitede bi kücük ekstra cikiyor manual kapat

        // 4. Verify url contains "formations"
        String expectedURL = "formations";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains(expectedURL)) {
            System.out.println("Url verification is passed");
        }else{
            System.out.println("Url verification is failed");
        }


        // 5. Navigate back, forward and refresh
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);


        // 6. Click on "Practice Site"
        driver.findElement(By.linkText("Practice Site")).click();


        // 7. Verify title is "Practice Test Automation WebSite"
        if(driver.getTitle().equals("Practice Test Automation WebSite")) {
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

        driver.quit();


    }
}
/*
Eğer implicitlyWait komutunu kodunuza yazdıysanız ancak sayfanız ve web elementleriniz normal bir şekilde hızla yükleniyorsa,
Selenium implicit wait süresi boyunca beklemez.Implicit wait yalnızca bir elementin bulunamadığı veya yüklenmediği durumda devreye girer.
Bu nedenle, eğer tüm öğeler sayfa yüklendiğinde anında erişilebilir durumdaysa,bekleme süresinin tamamını beklemez.
 */