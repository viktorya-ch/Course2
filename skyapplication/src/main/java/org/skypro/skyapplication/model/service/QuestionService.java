package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;

import java.util.Collection;


public interface QuestionService {

    Question addQuestion(Question question);

    Collection<Question> getAll();

    Question removeQuestion(Question question);


    Question getRandomQuestion ();

}
