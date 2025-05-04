package org.skypro.skyapplication.model.controller;



import org.skypro.skyapplication.model.question.Question;
import org.skypro.skyapplication.model.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    @Autowired
    public JavaQuestionController(JavaQuestionService javaQuestionService){
        this.javaQuestionService= javaQuestionService;
    }

    @GetMapping
    public String addQuestion(@RequestParam String question, @RequestParam String answer){
        Question newQuestion = new Question(question,answer);
        javaQuestionService.addQuestion(" Java Core ", newQuestion);
        return " Новый вопрос добавлен: " + newQuestion;
    }

    @GetMapping
    public String removeQuestion (@RequestParam String question){
        javaQuestionService.deleteQuestion(" Java Core ", question);
        return " Удаленный вопрос: " + question;
    }


    @GetMapping
    public List<Question>getAllQuestions(){
        return javaQuestionService.getQuestionsByLesson(" Java Core ");
    }
}
