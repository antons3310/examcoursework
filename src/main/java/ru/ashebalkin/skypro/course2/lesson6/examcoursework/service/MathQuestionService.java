package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questionsForPrint = new ArrayList<>(questionRepository.getAll());
        Random random = new Random();
        return questionsForPrint.get(random.nextInt(questionsForPrint.size() - 1));
    }
}
