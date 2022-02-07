package ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ответ на данный вопрос уже зарегистрирован")
public class AllReadyHaveAnswerException extends RuntimeException{
    public AllReadyHaveAnswerException() {
        super("Ответ на данный вопрос уже зарегистрирован");
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
