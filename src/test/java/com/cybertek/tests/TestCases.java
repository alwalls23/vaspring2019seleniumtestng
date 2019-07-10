package com.cybertek.tests;
/*
Go to ebay
enter ny search term
click on search button
print the number of results

TEST 2
go to amazon
enter any search term
click on search button
verify title contains search term

TEST 3
go to wikipedia.org
enter search term 'selenium webdriver'
click on search button
click on search result 'Selenium (software)'
verify url ends with 'Selenium_(software)'
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    public static void main(String[] args) throws InterruptedException{
    AmazonTest(); //Pass
    EbayTest(); //Pass
    WikiTest(); //Pass

    }
     public static void AmazonTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("water guns");
        Thread.sleep(1000);
        driver.findElement(By.className("nav-input")).click();

        if(driver.getTitle().contains("water guns")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

         System.out.println(driver.findElement(By.className("sg-col-inner")).getText());
         Thread.sleep(10000);
         driver.quit();
    }

    public static void EbayTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://wwww.ebay.com");
        Thread.sleep(1000);
        driver.findElement(By.id("gh-ac")).sendKeys("phone chargers");
        Thread.sleep(1000);
        driver.findElement(By.id("gh-btn")).click();

        System.out.println(driver.findElement(By.tagName("h1")).getText());
        Thread.sleep(10000);
        driver.quit();
    }

    public static void WikiTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");
        Thread.sleep(1000);
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        Thread.sleep(1000);
        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.linkText("Selenium (software)")).click();
        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(10000);
        driver.quit();
    }
}
