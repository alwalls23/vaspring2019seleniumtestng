package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Test 003
Open browser
go http://practice.cybertekschool.com/forgot_password
enter any email
click on Retrieve password
verify new confirmation message "Your e-mail's been sent!"

Test 004

open broser
to to http://practice.cybertekschool.com/forgot_password
enter any email
verify that email text is displayed
 */
public class TextVerification {
    public static void main(String[] args) throws InterruptedException {
//        test003();
        test004();
    }


    public static void test004() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1000);
        WebElement emailInput = driver.findElement(By.name("email"));
        String exp = "random_email@gmail.com";
        emailInput.sendKeys(exp);
        Thread.sleep(1000);

        //getAttribute --> returns the value of the given attribute of the element
        System.out.println(emailInput.getAttribute("name"));
        System.out.println(emailInput.getAttribute("type"));


        //getAttribute(value)--.>use this to get text input box etc
        String act = emailInput.getAttribute("value");
        VerificationUtils.verifyEquals(exp, act);

        //getAttribute("innerHTML") --> if getAttribute(value) does not work, use this one
        System.out.println(emailInput.getAttribute("innerHTML"));
        //getAttribute("outerHTML") --> returns the HTML of given element
        System.out.println(emailInput.getAttribute(("outerHTML")));

        // HOW TO DELETE TEXT FROM INPUT FIELD

        emailInput.clear();

        driver.quit();


    }

    public static void test003() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1000);
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("randomemail@gmail.com");

        Thread.sleep(1000);
        WebElement retrieveBtn = driver.findElement(By.id("form_submit"));
        retrieveBtn.click();

        WebElement message = driver.findElement(By.name("confirmation_message"));

        //getText() returns the text of a webelement
        System.out.println(message.getText());

        String exp = "Your e-mail's been sent!";

        driver.quit();



    }

}
