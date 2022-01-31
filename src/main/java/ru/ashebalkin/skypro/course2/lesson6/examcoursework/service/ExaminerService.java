package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
