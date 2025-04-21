package pro.sky.java.course2.question;

import java.util.List;

public interface QuestionService {

    void addQuestion (String lesson, Question question);

    List<Question> getQuestionsByLesson(String lesson);

    void deleteQuestion(String lesson, String question);

    void updateQuestion (String lesson, String oldQuestion, Question newQuestion);

}
