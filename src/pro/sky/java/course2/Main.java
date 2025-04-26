package pro.sky.java.course2;

import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.service.JavaQuestionService;

public class Main {
    public static void main(String[] args) {
        JavaQuestionService javaquestionService = new JavaQuestionService();

        javaquestionService.addQuestion(" Java Core ", new Question(" а? ", " б "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));
        javaquestionService.addQuestion(" Java Core ", new Question(" ?", " "));

        System.out.println(" Все вопросы по предмету " + javaquestionService.getQuestionsByLesson("Java Core"));

        System.out.println(" Рандомный вопрос: " + javaquestionService.getRandomQuestion());

        javaquestionService.updateQuestion(" Java Core ", " a? ", new Question(" т ", " н "));

        javaquestionService.deleteQuestion(" Java Core ", " a? ");

        System.out.println(" Все поросы по Java Core с изменениями: " + javaquestionService.getQuestionsByLesson(" Java Core "));
    }
}