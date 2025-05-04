package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{


    private final JavaQuestionService javaQuestionService;

    @Autowired
    public ExaminerServiceImpl(JavaQuestionService javaQuestionService){
        this.javaQuestionService=javaQuestionService;
    }

    @Override
    public List<Question> getQuestion(String lesson) {
        return javaQuestionService.getQuestionsByLesson(lesson);
    }
}
