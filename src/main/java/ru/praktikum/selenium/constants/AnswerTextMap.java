package ru.praktikum.selenium.constants;

import java.util.*;
import ru.praktikum.selenium.QuestionNumberValidator;

public class AnswerTextMap {
    public static String GetTextByQuestionNumber(Integer questionNumber) {
        QuestionNumberValidator.ValidateQuestionNumber(questionNumber);

        HashMap<Integer, String> text = new HashMap<Integer, String>();
        text.put(1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        text.put(2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        text.put(3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        text.put(4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        text.put(5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        text.put(6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        text.put(7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        text.put(8, "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

        return text.get(questionNumber);
    }
}