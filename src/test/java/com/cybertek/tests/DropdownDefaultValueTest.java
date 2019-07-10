package com.cybertek.tests;
/*
Test 1
Open url
verify default option for 1st dropdown is Please select option
close browser

Test 2
Open url
verify default option for year is 2019
close browser


Test 3
Open url
verify default option for states is Please select a state
close browser
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownDefaultValueTest {
    WebDriver driver;

    @Test
    public void dropdownTest() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        String expected = "Please select an option";
        String acutal = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(acutal, expected);
    }

    @Test
    public void dropdownTest2() {
        Select select = new Select(driver.findElement(By.id("year")));
        String expected = "2019";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void dropdownTest3(){
        Select select = new Select((driver.findElement(By.id("state"))));
        String expected = "Select a State";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
    }

    @AfterMethod
     public void tearDown() throws InterruptedException{
//            Thread.sleep(10000);
            driver.quit();
        }



}
