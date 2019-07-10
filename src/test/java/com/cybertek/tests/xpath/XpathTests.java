package com.cybertek.tests.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathTests {
    @Test
    public void absoluteXpath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expectedUrl = "http://practice.cybertekschool.com/signup_confirmation";
        driver.get(expectedUrl);

        System.out.println("Print the first link");
        System.out.println(driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());

        System.out.println("Printing second link");
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/div/a")).getText());

    }
        @Test
        public void relativeXPathUsingParentChild(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            String expectedUrl = "http://practice.cybertekschool.com/signup_confirmation";
            driver.get(expectedUrl);

            System.out.println("Print the first link");
            System.out.println(driver.findElement(By.xpath("//body/nav//a")).getText());

        }

        @Test
        public void relativeXpathUsingAttributeValue(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            System.out.println("Print the first link");
            driver.findElement(By.xpath("//button[@id='disappearing_button']")).click();

            //ANY TAG WITH ATTRIBUTE VALUE COMBO
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@id='disappearing_button']")).click();

            //CONTAINS CERTAIN STRING IN VALUE OF SOME ATTRIBUTE
            System.out.println(driver.findElement(By.xpath("//button[contains(@id, 'button_')]")).getText());
        }

        @Test
        public void relativeXPathUsingText(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            //USING EXACT TEXT
            System.out.println(driver.findElement(By.xpath("//button[.='Button 3']")).getText());
            System.out.println(driver.findElement(By.xpath("//*[.='Button 3']")).getText());

            //USING PARTIAL TEXT
            System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'click']")).getText());
        }

        @Test
        public void relativeXpathByIndex(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            System.out.println(driver.findElement(By.xpath("//button[2]")));
        }



}
