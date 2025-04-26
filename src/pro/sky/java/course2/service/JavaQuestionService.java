package pro.sky.java.course2.service;

import pro.sky.java.course2.question.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaQuestionService implements QuestionService {

    private final List<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
        this.random = new Random();
    }


    @Override
    public void addQuestion(String lesson, Question question) {
        if (" Java Core ".equalsIgnoreCase(lesson)) {
            questions.add(question);
        }

    }

    @Override
    public List<Question> getQuestionsByLesson(String lesson) {
        if (" Java Core ".equalsIgnoreCase(lesson)) {
            return new ArrayList<>(questions);
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteQuestion(String lesson, String question) {
        if (" Java Core ".equalsIgnoreCase(lesson)) {
            questions.removeIf(q -> q.getQuestion().equals(question));
        }

    }

    @Override
    public void updateQuestion(String lesson, String oldQuestion, Question newQuestion) {
        if (" Java Core ".equalsIgnoreCase(lesson)) {
            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getQuestion().equals(oldQuestion)) {
                    questions.set(i, newQuestion);
                    break;
                }
            }
        }

    }


    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}