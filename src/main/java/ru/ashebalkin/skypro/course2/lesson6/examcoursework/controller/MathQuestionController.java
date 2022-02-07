package ru.ashebalkin.skypro.course2.lesson6.examcoursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String helloMessage() {
        return "Добро пожаловать на экзаменационную страницу с вопросами по высшей математике";
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(questionService.add(question, answer));
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(questionService.add(question, answer));
    }

    @GetMapping("/find")
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

}
