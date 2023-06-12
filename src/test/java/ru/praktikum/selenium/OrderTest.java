package ru.praktikum.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.selenium.constants.OrderButtonLocation;
import ru.praktikum.selenium.constants.RentDurationLocation;
import ru.praktikum.selenium.constants.ScooterColour;
import ru.praktikum.selenium.pageobject.MainPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String myName;
    private final String mySurname;
    private final String myAddress;
    private final String myMetro;
    private final String myPhone;
    private final String orderDate;
    private final String rentDuration;
    private final String colour;
    private final String buttonNumber;

    public OrderTest(String myName, String mySurname, String myAddress, String myMetro, String myPhone,
                     String orderDate, String rentDuration, String colour, String buttonNumber) {
        this.myName = myName;
        this.mySurname = mySurname;
        this.myAddress = myAddress;
        this.myMetro = myMetro;
        this.myPhone = myPhone;
        this.orderDate = orderDate;
        this.rentDuration = rentDuration;
        this.colour = colour;
        this.buttonNumber = buttonNumber;
    }

    @Parameterized.Parameters
    public static Object[][] makeOrder() {
        return new Object[][] {
                { "Рената", "Литвинова", "На деревню дедушке", "Войковская", "89631234567",
                        "27.05.2023", RentDurationLocation.oneDay, ScooterColour.black, OrderButtonLocation.buttonOne},
                { "Нерената", "Осенняя", "На деревню дедушке", "Войковская", "89637654321",
                        "31.05.2023", RentDurationLocation.twoDays, ScooterColour.grey, OrderButtonLocation.buttonTwo},
        };
    }

    @Test
    public void CheckScooterOrder() {
        new MainPage(webDriver).acceptCookies()
                .clickNewOrderButton(buttonNumber)
                .checkOrderPersonalDataPageIsDisplayed()
                .enterPersonalData(myName, mySurname, myAddress, myMetro, myPhone)
                .checkScooterDetailsPageIsDisplayed()
                .enterScooterDetails(orderDate, rentDuration, colour)
                .checkOrderConfirmationIsDisplayed()
                .clickConfirmOrderButton()
                .checkOrderProcessed();
    }
}