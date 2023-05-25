package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderProcessedPage {
    WebDriver webDriver;

    private final By orderProcessedText = By.className("Order_Text__2broi");

    public OrderProcessedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void checkOrderProcessed(){
        var orderText = webDriver.findElement(orderProcessedText).getText();
        String successfulOrderText = "Номер заказа";
        Assert.assertTrue(String.format("Ошибка при оформлении заказа, не найден элемент: %s",
                successfulOrderText), orderText.contains(successfulOrderText));
    }
}