package ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionsException extends RuntimeException{
    public NotEnoughQuestionsException() {
        super("Запрошено большее количество вопросов, чем хранится в сервисе");
    }

    public NotEnoughQuestionsException(String message) {
        super(message);
    }

    public NotEnoughQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionsException(Throwable cause) {
        super(cause);
    }
}
