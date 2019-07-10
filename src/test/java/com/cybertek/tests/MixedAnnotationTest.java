package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MixedAnnotationTest {

    @BeforeMethod
    public void setup(){
        System.out.println("opening browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser\n");
    }

    @Test
    public void test1(){
        System.out.println("\ttesting test case 1");
    }

    @Test
    public void test2(){
        System.out.println("\ttesting test case 2");
    }

    @Test
    public void test3(){
        System.out.println("\ttesting test case 3");
    }
}
