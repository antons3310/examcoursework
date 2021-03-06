package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.AllReadyHaveAnswerException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.ashebalkin.skypro.course2.lesson6.examcoursework.constants.ExamTestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    private JavaQuestionService out;

    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @BeforeEach
    public void initTestService() {
        out = new JavaQuestionService(javaQuestionRepositoryMock);
    }

    @Test
    void addByTextTestSuccess() {
        assertEquals(out.add(JAVA_RIGHT_QUESTION_TEXT, JAVA_RIGHT_ANSWER_TEXT), JAVA_ETALON_QUESTION);
    }

    @Test
    void addByTextTestNotSuccess() {
        assertNotEquals(JAVA_ETALON_QUESTION, out.add(JAVA_WRONG_QUESTION_TEXT, JAVA_RIGHT_ANSWER_TEXT));
    }

    @Test
    void AddByObjectTest() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_EXPECTED_QUESTIONS);
        when(javaQuestionRepositoryMock.add(JAVA_ETALON_QUESTION)).thenReturn(JAVA_ETALON_QUESTION);
        assertTrue(out.getAll().contains(out.add(JAVA_ETALON_QUESTION)));
    }

    @Test
    void AddByObjectTestAllReadyHaveAnswer() {
        when(javaQuestionRepositoryMock.add(DUBLICATE_QUESTION_QUESTIONTEXT)).thenThrow(AllReadyHaveAnswerException.class);
        assertThrows(AllReadyHaveAnswerException.class, () -> out.add(DUBLICATE_QUESTION_QUESTIONTEXT));
    }

    @Test
    void AddByObjectTestQuestionAllReadyExist() {
        when(javaQuestionRepositoryMock.add(DUBLICATE_QUESTION)).thenThrow(QuestionAllReadyExistException.class);
        assertThrows(QuestionAllReadyExistException.class, () -> out.add(DUBLICATE_QUESTION));
    }

    @Test
    void removeTestSuccess() {
        when(javaQuestionRepositoryMock.remove(QUESTION_TO_REMOVE)).thenReturn(QUESTION_TO_REMOVE);
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_EXPECTED_QUESTIONS);
        assertFalse(out.getAll().contains(out.remove(QUESTION_TO_REMOVE)));
    }

    @Test
    void removeTestQuestionNotFound() {
        when(javaQuestionRepositoryMock.remove(QUESTION_TO_REMOVE)).thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_TO_REMOVE));
    }

    @Test
    void getAllTest() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_QUESTION_COLLECTION);
        assertTrue(JAVA_QUESTION_COLLECTION.containsAll(out.getAll()));
    }

}