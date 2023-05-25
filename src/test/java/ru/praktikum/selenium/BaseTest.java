package ru.praktikum.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver webDriver;

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void cleanup(){
        webDriver.quit();
    }
}