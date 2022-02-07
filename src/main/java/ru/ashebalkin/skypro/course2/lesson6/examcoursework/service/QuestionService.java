package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add (String question, String answer);

    Question add (Question question);

    Question remove (Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
