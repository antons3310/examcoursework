package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.NotEnoughQuestionsException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static ru.ashebalkin.skypro.course2.lesson6.examcoursework.constants.ExamTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    ExaminerServiceImpl out;

    @Mock
    private QuestionService questionServiceMock;

    @BeforeEach
    public void initTestService() {
        out = new ExaminerServiceImpl(questionServiceMock);
    }

    @Test
    void getQuestionsTest() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(ETALON_QUESTION_1, ETALON_QUESTION_2, ETALON_QUESTION_3, ETALON_QUESTION_4);
        when(questionServiceMock.getAll()).thenReturn(EXPECTED_QUESTIONS);
        assertTrue(EXPECTED_QUESTIONS.containsAll(out.getQuestions(QUESTIONS_COUNT)));
    }

    @Test
    void getQuestionsTestNotEnoughtQuestions() {
        assertThrows(NotEnoughQuestionsException.class, () -> out.getQuestions(NOT_ENOUGHT_QUESTION_COUNT));

    }
}