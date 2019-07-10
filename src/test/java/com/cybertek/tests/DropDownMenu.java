package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        WebElement selectElement  = driver.findElement(By.id("dropdown"));
        Select dropdownList = new Select(selectElement);

        // Read the selected option
        //getFirstSelectOption --> returns the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //Get all available options

        List<WebElement> allOptions = dropdownList.getOptions();
        System.out.println("Number of options: "+allOptions.size());

        for (WebElement option : allOptions){
            System.out.println(option.getText());
        }

        //How to select using visible text
        dropdownList.selectByVisibleText("Option 1");
        selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        Thread.sleep(3000);

        dropdownList.selectByVisibleText("Option 2");
        selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //How to select using Index
        Thread.sleep(3000);
        dropdownList.selectByIndex(1);
        selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //How to select using the value Attribute
        //<option value ="2">Option 2</option>
        dropdownList.selectByValue("2");

        selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        Thread.sleep(10000);
        driver.quit();
    }
}
