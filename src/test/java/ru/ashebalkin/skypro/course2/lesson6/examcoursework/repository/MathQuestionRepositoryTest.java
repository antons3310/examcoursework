package ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.AllReadyHaveAnswerException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ashebalkin.skypro.course2.lesson6.examcoursework.constants.ExamTestConstants.*;

class MathQuestionRepositoryTest {

    private MathQuestionRepository out;

    @BeforeEach
    public void initTestService() {
        out = new MathQuestionRepository();
    }

    @Test
    void AddByObjectTest() {
        out.add(MATH_ETALON_QUESTION);
        assertTrue(out.getAll().contains(MATH_ETALON_QUESTION));
    }

    @Test
    void AddByObjectTestAllReadyHaveAnswer() {
        out.add(DUBLICATE_QUESTION_QUESTIONTEXT);
        assertThrows(AllReadyHaveAnswerException.class, () -> out.add(DUBLICATE_QUESTION_QUESTIONTEXT_ANOTHER_ANSWER));
    }

    @Test
    void AddByObjectTestQuestionAllReadyExist() {
        out.add(DUBLICATE_QUESTION);
        assertThrows(QuestionAllReadyExistException.class, () -> out.add(DUBLICATE_QUESTION));
    }

    @Test
    void removeTestSuccess() {
        out.add(QUESTION_TO_REMOVE);
        out.remove(QUESTION_TO_REMOVE);
        assertFalse(out.getAll().contains(QUESTION_TO_REMOVE));
    }

    @Test
    void removeTestQuestionNotFound() {
        out.add(QUESTION_TO_REMOVE);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(MATH_ETALON_QUESTION));
    }

    @Test
    void getAllTest() {
        assertTrue(MATH_QUESTION_COLLECTION.containsAll(out.getAll()));
    }
}