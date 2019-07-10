package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckedBoxDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //verify default values

        WebElement one = driver.findElement(By.xpath("//input[1]"));
        WebElement two = driver.findElement(By.xpath("//input[2]"));

        System.out.println("One: "+one.isSelected());
        System.out.println("two: "+two.isSelected());

        Thread.sleep(3000);
        System.out.println("Clicking on one");
        one.click();

        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, true);

        Thread.sleep(3000);
        System.out.println("Clicking on two");
        two.click();

        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, false);

        // How to see if element is selected using its attributes
        System.out.println(one.getAttribute("type"));
        System.out.println(one.getAttribute("checked"));
        System.out.println(two.getAttribute("checked"));



        Thread.sleep(10000);
        driver.quit();
    }
}
