package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingNavigationCommand {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //      waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("Admin123");

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
