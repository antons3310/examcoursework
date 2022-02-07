package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.AllReadyHaveAnswerException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository.MathQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.ashebalkin.skypro.course2.lesson6.examcoursework.constants.ExamTestConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    private MathQuestionService out;

    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @BeforeEach
    public void initTestService() {
        out = new MathQuestionService(mathQuestionRepositoryMock);
    }

    @Test
    void addByTextTestSuccess() {
        assertEquals(out.add(MATH_RIGHT_QUESTION_TEXT, MATH_RIGHT_ANSWER_TEXT), MATH_ETALON_QUESTION);
    }

    @Test
    void addByTextTestNotSuccess() {
        assertNotEquals(MATH_ETALON_QUESTION, out.add(MATH_WRONG_QUESTION_TEXT, MATH_RIGHT_ANSWER_TEXT));
    }

    @Test
    void AddByObjectTest() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_EXPECTED_QUESTIONS);
        when(mathQuestionRepositoryMock.add(MATH_ETALON_QUESTION)).thenReturn(MATH_ETALON_QUESTION);
        assertTrue(out.getAll().contains(out.add(MATH_ETALON_QUESTION)));
    }

    @Test
    void AddByObjectTestAllReadyHaveAnswer() {
        when(mathQuestionRepositoryMock.add(DUBLICATE_QUESTION_QUESTIONTEXT)).thenThrow(AllReadyHaveAnswerException.class);
        assertThrows(AllReadyHaveAnswerException.class, () -> out.add(DUBLICATE_QUESTION_QUESTIONTEXT));
    }

    @Test
    void AddByObjectTestQuestionAllReadyExist() {
        when(mathQuestionRepositoryMock.add(DUBLICATE_QUESTION)).thenThrow(QuestionAllReadyExistException.class);
        assertThrows(QuestionAllReadyExistException.class, () -> out.add(DUBLICATE_QUESTION));
    }

    @Test
    void removeTestSuccess() {
        when(mathQuestionRepositoryMock.remove(QUESTION_TO_REMOVE)).thenReturn(QUESTION_TO_REMOVE);
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_EXPECTED_QUESTIONS);
        assertFalse(out.getAll().contains(out.remove(QUESTION_TO_REMOVE)));
    }

    @Test
    void removeTestQuestionNotFound() {
        when(mathQuestionRepositoryMock.remove(QUESTION_TO_REMOVE)).thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_TO_REMOVE));
    }

    @Test
    void getAllTest() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_QUESTION_COLLECTION);
        assertTrue(MATH_QUESTION_COLLECTION.containsAll(out.getAll()));
    }

}