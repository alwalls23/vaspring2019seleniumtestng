package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Major Payne");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bringOnThePayne@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
