package ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository;

import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();


}
