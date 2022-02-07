package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.NotEnoughQuestionsException;

import java.util.Collection;
import java.util.HashSet;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        HashSet<Question> questionsForExam = new HashSet<>();

        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionsException();
        }

        do {
            Question questionCurr = questionService.getRandomQuestion();
            questionsForExam.add(questionCurr);
        } while (questionsForExam.size() < amount);

        return questionsForExam;
    }
}
