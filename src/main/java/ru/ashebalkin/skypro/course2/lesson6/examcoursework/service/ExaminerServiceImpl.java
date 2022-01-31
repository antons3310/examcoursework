package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;

import java.util.Collection;
import java.util.Random;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
