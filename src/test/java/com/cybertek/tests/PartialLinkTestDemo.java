package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkTestDemo {
    public static void main(String[] args)throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        driver.findElement(By.partialLinkText("Auto")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println(driver.findElement(By.id("result")).getText());

        Thread.sleep(6000);
        driver.quit();


    }
}
