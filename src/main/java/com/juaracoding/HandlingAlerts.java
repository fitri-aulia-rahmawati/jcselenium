package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingAlerts {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        //      waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        // handling Alerts 1
        WebElement clickAlertButton = driver.findElement(By.id("alertButton"));
        clickAlertButton.click();
        driver.switchTo().alert().accept();
        System.out.println("Alert ok Clicked");

        // handling Alerts 2
//        WebElement clickTimeButton = driver.findElement(By.id("timerAlertButton"));
//        clickTimeButton.click();
//        driver.switchTo().alert().accept();
//        clickTimeButton.click();
//        driver.switchTo().alert().dismiss();
//        System.out.println("Alert ok Clicked");

        // handling Alerts 3
        WebElement clickConfirmButton = driver.findElement(By.id("confirmButton"));
        clickConfirmButton.click();
        delay(5);
        driver.switchTo().alert().accept();
        clickConfirmButton.click();
        driver.switchTo().alert().dismiss();
        System.out.println("Alert Cancel Clicked");

        // handling Alerts 4
        js.executeScript("window.scrollBy(0,250)");
        WebElement clickPromtButton = driver.findElement(By.id("promtButton"));
        delay(5);
        driver.switchTo().alert().accept();
        System.out.println("Alert ok Clicked");
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("Fitri");
        clickPromtButton.click();

        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000); // delay 5 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
