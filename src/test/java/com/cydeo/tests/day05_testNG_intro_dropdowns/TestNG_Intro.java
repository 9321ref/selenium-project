package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {


    @BeforeClass   // run once time before all other method
    public void setupClass(){
        System.out.println("----> Before class is running");
    }


    @AfterClass    // run once time after all other methods are done
    public void tearDownClass(){
        System.out.println("----> After class is running");
    }


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> Before method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> After method is running...");
    }


    @Test (priority = 2)  // -> test 1 olsada ikinci run olur.normalde alfabetik yada numaratik sirayla run olur
    public void test1(){
        System.out.println("Test 1 is running...");

        // Assert Equals method will compare two of the same values. If returns true, pass.False, fails.
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual,expected); // if assertion is failed ,after assertion line cannot run.this test will stop

    }

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test 2 is running...");

        String actual = "white";
        String expected = "white";

        Assert.assertTrue(actual.equals(expected));
    }


}
