package org.skypro.skyapplication.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.skyapplication.model.question.Question;
import org.skypro.skyapplication.model.service.JavaQuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;


    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddQuestion() {
        Collection<Question> questionsBefore = javaQuestionService.getAll();
        int sizeBefore = questionsBefore.size();
        Question question = new Question(" Что такое переменная? ", "Область в памяти компьютера для хранения данных, которой можно присвоить имя ");
        javaQuestionService.addQuestion(question);
        Collection<Question> questionsAfter = javaQuestionService.getAll();
        assertEquals(sizeBefore + 1, questionsAfter.size());
        boolean found = questionsAfter.contains(question);
        assertTrue(found, " Новый вопрос присутствует в списке ");


    }

    @Test
    void testDeleteQuestion() {
        Question question = new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной ");
        javaQuestionService.addQuestion(question);
        assertEquals(1, javaQuestionService.getAll().size());
        javaQuestionService.removeQuestion(question);
        assertEquals(0, javaQuestionService.getAll().size());
    }


    @Test
    void testGetRandomQuestion() {
        List<Question> questions = new ArrayList<>();
        javaQuestionService.addQuestion(new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной "));
        javaQuestionService.addQuestion(new Question(" Что такое переменная? ", "Область в памяти компьютера для хранения данных, которой можно присвоить имя "));
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertTrue(randomQuestion.getQuestion().equals(" Что такое инициализация переменной? ") || randomQuestion.getQuestion().equals(" Что такое переменная? "));


    }

}
