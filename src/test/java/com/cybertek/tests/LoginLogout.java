package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout {
    public static void main(String[] args) throws InterruptedException {
    Login();
    }

    public static void Login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();
        System.out.println("Log in page loaded?");

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        Thread.sleep(1000);
        WebElement enterUsername = driver.findElement(By.id("prependedInput"));
        enterUsername.sendKeys("user22");

        Thread.sleep(1000);
        WebElement enterPassword = driver.findElement(By.id("prependedInput2"));
        enterPassword.sendKeys("UserUser123");

        Thread.sleep(1000);
        WebElement clickBtn = driver.findElement(By.id("_submit"));
        clickBtn.click();

        Thread.sleep(1000);
        expectedTitle = "Dashboard";
        actualTitle = driver.getTitle();
        System.out.println("Log in successful?");

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        Thread.sleep(1000);
        driver.findElement(By.className("dropdown-toggle")).click();

        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();

        expectedTitle = "Login";
        actualTitle = driver.getTitle();
        System.out.println("Log out successful?");

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS - Successfully logged out!");
        }else{
            System.out.println("FAIL - Did not log out.");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
        Thread.sleep(10000);
        driver.quit();
    }
}
