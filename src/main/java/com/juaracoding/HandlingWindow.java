package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        //      waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        driver.findElement(By.id("tabButton")).click();
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
//switch to new tab
        driver.switchTo().window(newTb.get(1));
        String page = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Page title of new tab: " + page);
//switch to parent window
        driver.switchTo().window(newTb.get(0));
        String pageTwo = driver.findElement(By.className("main-header")).getText();
        System.out.println("Page title of parent window: " + pageTwo);

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
