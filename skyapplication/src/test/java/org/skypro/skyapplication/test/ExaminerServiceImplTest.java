package org.skypro.skyapplication.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.skyapplication.model.question.Question;
import org.skypro.skyapplication.model.service.ExaminerServiceImpl;
import org.skypro.skyapplication.model.service.JavaQuestionService;
import org.skypro.skyapplication.model.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuestions_Success() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(" Что такое инициализация переменной? ", " Присвоение какого-то значения переменной "));
        when(questionService.getQuestionsByLesson(" Java ")).thenReturn(questions);
        List<Question> result = examinerService.getQuestion(15);
        assertEquals(1, result.size());
        assertEquals(" Что такое инициализация переменной? ", result.get(0).getQuestion());
    }


}

