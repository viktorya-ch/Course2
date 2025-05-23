package org.skypro.skyapplication.model.controller;

import org.skypro.skyapplication.model.question.Question;
import org.skypro.skyapplication.model.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions(@RequestParam int amount) {
        {
            List<Question> questions = examinerService.getQuestion(amount);
            return ResponseEntity.ok(questions);
        }
    }
}
