package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
        this.random = new Random();
        initializeQuestions();
    }
    private void initializeQuestions(){
        questions.add(new Question(" Какие методы называют ленивыми? ", " Которые не срабатывают до их непосредственного вызова "));
        questions.add(new Question(" Что такое итерация? ", " Очередной проход цикла "));
        questions.add(new Question(" Можно ли изменять строку? ", " Нет, нужно создать новую "));
        questions.add(new Question(" Что позволяет сделать механизм наследования? ", " Внести общий для двух объектов код в отдельный класс "));
        questions.add(new Question(" Что такое абстрактные методы? ", " Методы, которые мы объявляем, но не пишем для них реализацию "));
        questions.add(new Question(" Что такое статическая переменная? ", " Переменная, которая принадлежит не отдельному объекту класса, а всему классу "));
        questions.add(new Question(" Как называется механизм, схожий с переопределением метода, но используемый гораздо реже? ", " Перегрузка метода "));
        questions.add(new Question(" Как называется блок кода, который выполняет определенную функцию? ", " Метод "));
        questions.add(new Question(" Какие тесты считаются самыми простыми в разработке и поддержке? ", " Юнит-тесты "));
        questions.add(new Question(" Что такое ругрессионная ошибка? ", " Ошибка, возникающая при изменении уже работающего приложения "));
        questions.add(new Question(" Что такое Map? ", " Хранилище, в котором элементы стоят в парах ключ-значение "));
        questions.add(new Question(" Массив какого типа нельзя создать? ", " Можно создать массив любого типа "));
    }



    @Override
    public void addQuestion(Question question) {
       // if (" Java ".equalsIgnoreCase()) {
            questions.add(question);
        }



    @Override
    public List<Question> getQuestionsByLesson(String lesson) {
        if (" Java ".equalsIgnoreCase(lesson)) {
            return new ArrayList<>(questions);
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteQuestion(String lesson, String question) {
        if (" Java ".equalsIgnoreCase(lesson)) {
            questions.removeIf(q -> q.getQuestion().equals(question));
        }

    }

    @Override
    public void updateQuestion(String lesson, String oldQuestion, Question newQuestion) {
        if (" Java ".equalsIgnoreCase(lesson)) {
            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getQuestion().equals(oldQuestion)) {
                    questions.set(i, newQuestion);
                    break;
                }
            }
        }

    }


    public Question getRandomQuestion(String lesson) {
        List<Question> questions = getQuestionsByLesson(lesson);
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}