package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(){
        WebDriver webDriver;
        String browserName = System.getProperty("browserName");
        switch(browserName){
            case "chrome":
                webDriver = new ChromeDriver();
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                WebDriverManager.firefoxdriver().setup();
                break;
            default: throw new RuntimeException("Browser is not detected.");
        }
        return webDriver;
    }
}