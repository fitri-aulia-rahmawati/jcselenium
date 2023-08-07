package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        //      waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        WebElement samplePage = driver.findElement(By.id("sampleHeading"));
        String textSamplePage = samplePage.getText(); //scrapping
        System.out.println(textSamplePage);
        driver.switchTo().defaultContent();

        js.executeScript("window.scrollBy(0,250)");
        WebElement frameTwo = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frameTwo);
        WebElement samplePageTwo = driver.findElement(By.id("sampleHeading"));
        String textSamplePageTwo = samplePageTwo.getText(); //scrapping
        System.out.println(textSamplePageTwo);

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
