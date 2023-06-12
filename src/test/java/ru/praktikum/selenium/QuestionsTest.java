package ru.praktikum.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.selenium.pageobject.MainPage;

@RunWith(Parameterized.class)
public class QuestionsTest extends BaseTest{
    private final Integer question;
    public QuestionsTest(Integer question) {
        this.question = question;
    }

    @Parameterized.Parameters
    public static Object[][] selectQuestion() {
        return new Object[][] {
                {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}
        };
    }
    @Test
    public void CheckAnswerMatch() {

        new MainPage(webDriver).acceptCookies()
                .FindAnswersSection()
                .OpenAnswerByQuestionNumber(question)
                .CheckAnswerCorrectness(question);
    }
}