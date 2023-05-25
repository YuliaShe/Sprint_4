package ru.praktikum.selenium;

import org.openqa.selenium.InvalidArgumentException;

public class QuestionNumberValidator{

    public static void ValidateQuestionNumber(Integer questionNumber){
        if(questionNumber > 8 || questionNumber < 1)
            throw new InvalidArgumentException("Question number should be from 1 to 8.");
    }
}