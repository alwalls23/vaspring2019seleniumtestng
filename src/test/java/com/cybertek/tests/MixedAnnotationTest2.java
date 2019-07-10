package com.cybertek.tests;

import org.testng.annotations.*;

public class MixedAnnotationTest2 {

    @BeforeClass
    public void setUpClass(){
        System.out.println("setting path");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("reporting everything");
    }

//    @BeforeMethod
//    public void setup(){
//        System.out.println("opening browser");
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        System.out.println("closing browser\n");
//    }

    @Test
    public void test1(){
        System.out.println("\ttesting test case 1");
    }

    @Test
    public void test2(){
        System.out.println("\ttesting test case 2");
    }

}
