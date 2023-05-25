package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPersonalDataPage {

    WebDriver webDriver;
    //Заголовок формы "Для кого самокат"
    private final By pageHeader = By.className("Order_Header__BZXOb");
    //Поле "Имя"
    private final By nameField = By.cssSelector("[placeholder ='* Имя']");
    //Поле "Фамилия"
    private final By surnameField = By.cssSelector("[placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By addressField = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция Метро"
    private final By metroField = By.cssSelector("[placeholder='* Станция метро']");
    //Поле "Телефон"
    private final By phoneField = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//*[contains(text(), 'Далее')]");

    public OrderPersonalDataPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderPersonalDataPage checkOrderPersonalDataPageIsDisplayed() {
        var isDisplayed = webDriver.findElement(pageHeader).isDisplayed();
        Assert.assertTrue("Personal data page was not displayed.", isDisplayed);
        return this;
    }

    public OrderScooterDetailsPage enterPersonalData(String name, String surname,
                                                     String address, String metro, String phone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetro(metro);
        enterPhone(phone);
        clickNextButton();

        return new OrderScooterDetailsPage(webDriver);
    }

    private void enterName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    private void enterSurname(String surname) {
        webDriver.findElement(surnameField).sendKeys(surname);
    }

    private void enterAddress(String address) {
        webDriver.findElement(addressField).sendKeys(address);
    }

    private void enterMetro(String metro) {
        webDriver.findElement(metroField).sendKeys(metro, Keys.DOWN, Keys.ENTER);
    }

    private void enterPhone(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    private void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }
}