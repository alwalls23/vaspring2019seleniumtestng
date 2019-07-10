package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectLists {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();



        Select list = new Select(driver.findElement(By.name("Languages")));

        //In a multi select we can select multiple options
        list.selectByVisibleText("Java");
        Thread.sleep(2000);
        list.selectByVisibleText("Python");
        list.selectByVisibleText("JavaScript");
        list.selectByVisibleText("C#");
        list.selectByVisibleText("C");

        //getAllSelectedOptions
        for (WebElement selectedOption: list.getAllSelectedOptions()) {
            System.out.println(selectedOption.getText());
        }

        //deselectByValue --> unselects selected option
        Thread.sleep(1000);
        list.deselectByVisibleText("Java");
        list.deselectByVisibleText("JavaScript");
        list.deselectByVisibleText("C#");
        list.deselectByVisibleText("C");

        Thread.sleep(10000);
        driver.quit();
    }
}
