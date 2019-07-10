package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrueTest {

    @Test
    public void test(){
        System.out.println(1==1);
        Assert.assertTrue(1==1);

        String url = "https://google.com";
        String expStr = ".com";

        Assert.assertTrue(url.endsWith(expStr));

        Assert.assertTrue(true);

    }
}
