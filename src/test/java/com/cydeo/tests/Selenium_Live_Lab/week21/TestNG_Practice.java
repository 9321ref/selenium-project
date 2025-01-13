package com.cydeo.tests.Selenium_Live_Lab.week21;

import org.testng.annotations.Test;

public class TestNG_Practice {


    public void test1(){

    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){

    }

    @Test (groups = "regression")
    public void test4(){

    }

    @Test (dependsOnMethods = "test4")
    public void test5(){

    }

    @Test(priority = 1)
    public void test6(){
        System.out.println("Test 6");
    }

    @Test (priority = 3)
    public void test7(){
        System.out.println("Test 7");
    }
    @Test (priority = 2)
    public void test8(){
        System.out.println("Test 8");
    }

    @Test
    public void testWithoutPriority(){
        System.out.println("Test WithoutPriority");
    }
}




