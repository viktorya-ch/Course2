package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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
        Collection<Question> availableQuestions = questionService.getAll();
        if (availableQuestions.size() >= MAX_QUESTIONS) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Запрошено слишком много вопросов ");
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            Question randomQuestion = ((JavaQuestionService) questionService).getRandomQuestion();
            if (randomQuestion != null) {
                uniqueQuestions.add(randomQuestion);
            } else {
                break;
            }
        }
        return List.copyOf(uniqueQuestions);
    }

}
