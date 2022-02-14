package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.NotEnoughQuestionsException;

import java.util.Collection;
import java.util.HashSet;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        HashSet<Question> questionsForExam = new HashSet<>();

        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new NotEnoughQuestionsException();
        }

        do {
            Question javaQuestionCurr = javaQuestionService.getRandomQuestion();
            questionsForExam.add(javaQuestionCurr);
            if (questionsForExam.size() == amount) {
                break;
            }
            Question mathQuestionCurr = mathQuestionService.getRandomQuestion();
            questionsForExam.add(mathQuestionCurr);
        } while (questionsForExam.size() < amount);

        return questionsForExam;
    }
}
