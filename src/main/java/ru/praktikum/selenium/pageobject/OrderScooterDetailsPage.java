package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.praktikum.selenium.constants.RentDurationLocation;
import ru.praktikum.selenium.constants.ScooterColour;

public class OrderScooterDetailsPage {

    WebDriver webDriver;
    //Заголовок формы "Про аренду"
    private final By pageHeader = By.className("Order_Header__BZXOb");
    //Поле "Когда привезти самокат"
    private final By orderDate = By.cssSelector("[placeholder='* Когда привезти самокат']");
    //Поле "Срок аренды" - стрелка, открывающая выпадающий список
    private final By rentDurationArrow = By.className("Dropdown-arrow");
    //Список сроков аренды:
    private final By oneDay = By.cssSelector(RentDurationLocation.oneDay);
    private final By twoDays = By.cssSelector(RentDurationLocation.twoDays);
    private final By threeDays = By.cssSelector(RentDurationLocation.threeDays);
    private final By fourDays = By.cssSelector(RentDurationLocation.fourDays);
    private final By fiveDays = By.cssSelector(RentDurationLocation.fiveDays);
    private final By sixDays = By.cssSelector(RentDurationLocation.sixDays);
    private final By sevenDays = By.cssSelector(RentDurationLocation.sevenDays);
    //Цвет самоката - серый
    private final By greyScooter = By.xpath("//*[@id=\"grey\"]");
    //Цвет самоката - черный
    private final By blackScooter = By.xpath("//*[@id=\"black\"]");
    //Кнопка "Заказать"
    private final By doOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    public OrderScooterDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderScooterDetailsPage checkScooterDetailsPageIsDisplayed(){
        var isDisplayed = webDriver.findElement(pageHeader).isDisplayed();
        Assert.assertTrue("Scooter description page was not displayed.", isDisplayed);
        return this;
    }

    public OrderConfirmationPage enterScooterDetails(String date, String rentDuration, String colour){
        enterScooterOrderDate(date);
        enterScooterRentDuration(rentDuration);
        enterScooterColour(colour);
        clickOrderButton();

        return new OrderConfirmationPage(webDriver);
    }

    private void enterScooterOrderDate(String date){
        webDriver.findElement(orderDate).sendKeys(date, Keys.DOWN, Keys.ENTER);
    }

    private void enterScooterRentDuration(String rentDuration){
        webDriver.findElement(rentDurationArrow).click();

        By duration;
        switch (rentDuration){
            case RentDurationLocation.oneDay:
                duration = oneDay;
                break;
            case RentDurationLocation.twoDays:
                duration = twoDays;
                break;
            case RentDurationLocation.threeDays:
                duration = threeDays;
                break;
            case RentDurationLocation.fourDays:
                duration = fourDays;
                break;
            case RentDurationLocation.fiveDays:
                duration = fiveDays;
                break;
            case RentDurationLocation.sixDays:
                duration = sixDays;
                break;
            case RentDurationLocation.sevenDays:
                duration = sevenDays;
                break;
            default: throw new InvalidArgumentException("Invalid rent duration.");
        }
        webDriver.findElement(duration).click();
    }

    private void enterScooterColour(String colour){
        if (colour .equals(ScooterColour.grey)) {
            webDriver.findElement(greyScooter).click();
        }
        else if (colour.equals(ScooterColour.black)) {
            webDriver.findElement(blackScooter).click();
        }
        else throw new InvalidArgumentException("Invalid scooter colour.");
    }

    private void clickOrderButton(){
        webDriver.findElement(doOrderButton).click();
    }
}