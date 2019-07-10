package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VerifyStatesNames {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        WebElement selectE1 = driver.findElement(By.id("state"));
        Select states = new Select(selectE1);

        List<WebElement> options = states.getOptions();
        System.out.println(options.size());

        //iterate through the options and compare one option to the next one
        for (int i = 1; i < options.size()-1; i++){
            String current = options.get(i).getText();
            String next = options.get(i+1).getText();
            System.out.println("Comparing: "+current+ " "+ next);
            if(current.compareTo(next) < 0){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
        }

        Thread.sleep(10000);
        driver.quit();
    }
}
