package ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAllReadyExistException extends RuntimeException{
    public QuestionAllReadyExistException() {
        super("Добавляемый вопрос уже есть в базе данных");
    }

    public QuestionAllReadyExistException(String message) {
        super(message);
    }

    public QuestionAllReadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAllReadyExistException(Throwable cause) {
        super(cause);
    }
}
