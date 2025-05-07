package org.skypro.skyapplication.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.skyapplication.model.question.Question;
import org.skypro.skyapplication.model.service.JavaQuestionService;

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
        List<Question>questionsBefore = javaQuestionService.getQuestionsByLesson(" Java ");
        int sizeBefore = questionsBefore.size();
        Question question=new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной ");
        javaQuestionService.addQuestion(new Question (" Что такое переменная? ","Область в памяти компьютера для хранения данных, которой можно присвоить имя "));
        List<Question>questionsAfter=javaQuestionService.getQuestionsByLesson(" Java ");
        assertEquals(sizeBefore + 1, questionsAfter.size());
        boolean found=questionsAfter.stream().anyMatch(q->"Что такое инициализация переменной?".equals(q.getQuestion()));
        assertTrue(found," Новый вопрос присутствует в списке ");


    }

    @Test
    void testDeleteQuestion() {
        Question question = new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной ");
        javaQuestionService.addQuestion(question);
        assertEquals(1, javaQuestionService.getQuestionsByLesson(" Java ").size());
        javaQuestionService.deleteQuestion(" Java ", " Что такое инициализация переменной? ");
        assertEquals(0, javaQuestionService.getQuestionsByLesson(" Java ").size());
    }

    @Test
    void testUpdateQuestion() {
        Question question = new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной ");
        javaQuestionService.addQuestion(question);
        Question newQuestion = new Question(" Что такое инициализация переменной? ", " Updated answer ");
        javaQuestionService.updateQuestion(" Java ", " Что такое инициализация переменной? ", newQuestion);
        List<Question> questions = javaQuestionService.getQuestionsByLesson(" Java ");
        assertEquals(" Обновленный ответ ", questions.get(0).getAnswer());
    }

    @Test
    void testGetRandomQuestion() {
        javaQuestionService.addQuestion( new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной "));
        javaQuestionService.addQuestion(new Question(" Что такое переменная? ", " Область в памяти компьютера для хранения данных, которой можно присвоить имя "));
        Question randomQuestion = javaQuestionService.getRandomQuestion(" Java ");
        assertNotNull(randomQuestion);
        assertTrue(randomQuestion.getQuestion().equals("Что такое инициализация переменной?") || randomQuestion.getQuestion().equals(" Что такое переменная? "));

    }

}
