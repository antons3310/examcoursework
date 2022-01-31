package ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AllReadyHaveAnswerException extends RuntimeException{
    public AllReadyHaveAnswerException() {
        super("На данный вопрос ответ уже зарегистрирован");
    }

    public AllReadyHaveAnswerException(String message) {
        super(message);
    }

    public AllReadyHaveAnswerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AllReadyHaveAnswerException(Throwable cause) {
        super(cause);
    }
}
