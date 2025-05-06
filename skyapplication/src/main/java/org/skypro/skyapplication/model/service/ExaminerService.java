package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;

import java.util.List;

public interface ExaminerService {
    List<Question>getQuestion(String lesson);
}
