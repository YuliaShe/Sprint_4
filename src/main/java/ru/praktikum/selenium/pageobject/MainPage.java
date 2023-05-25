package ru.praktikum.selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import ru.praktikum.selenium.QuestionNumberValidator;
import ru.praktikum.selenium.constants.AnswerTextMap;
import ru.praktikum.selenium.constants.OrderButtonLocation;

import static ru.praktikum.selenium.constants.AppConfig.siteAddress;

public class MainPage {

    WebDriver webDriver;
    //Принять куки
    private final By acceptCookies = By.id("rcc-confirm-button");
    //Кнопка заказа 1
    private final By newOrderButtonOne = By.className(OrderButtonLocation.buttonOne);
    //Кнопка заказа 2
    private final By newOrderButtonTwo = By.xpath(OrderButtonLocation.buttonTwo);
    //Секция вопросов
    private final By answersSection = By.className("Home_SubHeader__zwi_E");
    //Паттерн для кнопки, раскрывающей ответ
    final String answerButtonPattern = "#accordion__heading-~.accordion__button";
    //Паттерн для блока ответа
    final String answerIdPattern = "accordion__panel-~";

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(siteAddress);
    }
    public MainPage acceptCookies(){
        webDriver.findElement(acceptCookies).click();
        return this;
    }
    public OrderPersonalDataPage clickNewOrderButton(String buttonNumber){
        if (buttonNumber.equals(OrderButtonLocation.buttonOne))
        {
            webDriver.findElement(newOrderButtonOne).click();
        }
        else if (buttonNumber.equals(OrderButtonLocation.buttonTwo))
        {
            webDriver.findElement(newOrderButtonTwo).click();
        }
        else throw new InvalidArgumentException("Invalid button number.");
        return new OrderPersonalDataPage(webDriver);
    }

    public MainPage FindAnswersSection(){
        var element = webDriver.findElement(answersSection);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainPage OpenAnswerByQuestionNumber(Integer questionNumber){
        QuestionNumberValidator.ValidateQuestionNumber(questionNumber);

        var questionIdButton = answerButtonPattern.replaceAll
                ("~", Integer.toString(questionNumber -1));
        var element = webDriver.findElement(By.cssSelector(questionIdButton));
        ((JavascriptExecutor)webDriver).executeScript(
                "arguments[0].scrollIntoView();", element);
        element.click();

        return this;
    }

    public void CheckAnswerCorrectness(Integer questionNumber){
        QuestionNumberValidator.ValidateQuestionNumber(questionNumber);

        var answerIdForLocator = answerIdPattern.replaceAll
                ("~", Integer.toString(questionNumber -1));
        var actualText = webDriver.findElement(By.id(answerIdForLocator)).getText();
        var expectedText = AnswerTextMap.GetTextByQuestionNumber(questionNumber);

        Assert.assertEquals(String.format(("Wrong answer text, expected %s, but got %s."),
                expectedText, actualText), expectedText, actualText);
    }
}