package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumHandlingSelect {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        //      waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        // handling
        driver.findElement(By.id("oldSelectMenu")).sendKeys("Voilet");
        // cara 2
        WebElement selectColors = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColors);
        select.selectByValue("2");

        delay();
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(){
        try {
            Thread.sleep(5000); // delay 5 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
