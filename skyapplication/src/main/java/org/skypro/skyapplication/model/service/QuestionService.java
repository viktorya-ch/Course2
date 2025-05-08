package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    List<Question> getQuestionsByLesson(String lesson);

    void deleteQuestion(String question);

    void updateQuestion(String lesson, String oldQuestion, Question newQuestion);

    Question getRandomQuestion (String lesson);

}
