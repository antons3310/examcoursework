package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAllReadyExistException();
        }
        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questionsForPrint = new ArrayList<>(questions);
        Random random = new Random();
        return questionsForPrint.get(random.nextInt(questionsForPrint.size()-1));
    }

}
