package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    WebDriver webDriver;
    //"Хотите оформить заказ?"
    private final By confirmationText = By.className("Order_ModalHeader__3FDaJ");
    //Кнопка подтверждения заказа
    private final By confirmOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public OrderConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderConfirmationPage checkOrderConfirmationIsDisplayed(){
        var confirmationIsDisplayed = webDriver.findElement(confirmationText).isDisplayed();
        Assert.assertTrue("Scooter order confirmation page was not displayed.", confirmationIsDisplayed);
        return this;
    }

    public OrderProcessedPage clickConfirmOrderButton(){
        webDriver.findElement(confirmOrderButton).click();
        return new OrderProcessedPage(webDriver);
    }
}