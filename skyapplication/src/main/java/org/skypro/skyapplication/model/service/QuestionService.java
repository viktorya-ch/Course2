package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;

import java.util.List;

public interface QuestionService {

    void addQuestion(String lesson, Question question);

    List<Question> getQuestionsByLesson(String lesson);

    void deleteQuestion(String lesson, String question);

    void updateQuestion(String lesson, String oldQuestion, Question newQuestion);

}
