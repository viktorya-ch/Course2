package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;
    private final int MAX_QUESTIONS = 100;


    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestion(int amount) {
        List<Question> availableQuestions = questionService.getQuestionsByLesson(" Java ");
        if (availableQuestions.size() >= MAX_QUESTIONS) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Запрошено слишком много вопросов ");
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            Question randomQuestion = ((JavaQuestionService) questionService).getRandomQuestion(" Java ");
            if (randomQuestion != null) {
                uniqueQuestions.add(randomQuestion);
            } else {
                break;
            }
        }
        return List.copyOf(uniqueQuestions);
    }

}
