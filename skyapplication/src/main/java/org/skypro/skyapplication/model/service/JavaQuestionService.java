package org.skypro.skyapplication.model.service;

import org.skypro.skyapplication.model.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();

    }

    private void initializeQuestions() {
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
    public Question addQuestion(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }


    @Override
    public Question removeQuestion(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new NoSuchElementException(" Такой вопрос отсутствует ");
    }


    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException(" База пустая ");
        }
        List<Question>questionList = new ArrayList<>(questions);
        int randomIndex = random.nextInt(questions.size());
        return questionList.get(randomIndex);
    }
}