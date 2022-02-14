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
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    @BeforeEach
    public void initTestService() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    @Test
    void getQuestionsTest() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(JAVA_ETALON_QUESTION_1, JAVA_ETALON_QUESTION_2, JAVA_ETALON_QUESTION_3, JAVA_ETALON_QUESTION_4);
        when(javaQuestionServiceMock.getAll()).thenReturn(JAVA_EXPECTED_QUESTIONS);
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(MATH_ETALON_QUESTION_1, MATH_ETALON_QUESTION_2, MATH_ETALON_QUESTION_3, MATH_ETALON_QUESTION_4);
        when(mathQuestionServiceMock.getAll()).thenReturn(MATH_EXPECTED_QUESTIONS);
        assertTrue(BOTH_EXPECTED_QUESTIONS.containsAll(out.getQuestions(QUESTIONS_COUNT)));
    }

    @Test
    void getQuestionsTestNotEnoughtQuestions() {
        assertThrows(NotEnoughQuestionsException.class, () -> out.getQuestions(NOT_ENOUGHT_QUESTION_COUNT));

    }
}