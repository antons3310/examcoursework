package ru.ashebalkin.skypro.course2.lesson6.examcoursework.repository;

import org.springframework.stereotype.Repository;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.AllReadyHaveAnswerException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("Сотая часть числа?",
                "Процент"));
        questions.add(new Question("Что легче: 1 кг ваты или 1 кг железа?",
                "Одинаково"));
        questions.add(new Question("Может ли при умножении получиться ноль?",
                "Да"));
        questions.add(new Question("Чему равна четверть часа?",
                "15 минут"));
        questions.add(new Question("Специфическая единица измерения объёма нефти?",
                "Баррель."));
        questions.add(new Question("Первая координата точки?",
                "Абсцисса"));
        questions.add(new Question("Наука, изучающая свойства фигур на плоскости?",
                "Планиметрия"));
        questions.add(new Question("Прибор для измерения углов?",
                "Транспортир"));
        questions.add(new Question("Учёный, наиболее известным достижением которого стало «решето» для отсеивания простых чисел?",
                "Эратосфен"));
        questions.add(new Question("Утверждение, требующее доказательства?",
                "Теорема"));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAllReadyExistException();
        }

        if (questions.stream().anyMatch(question1 -> Objects.equals(question1.getQuestion(), question.getQuestion()))) {
            throw new AllReadyHaveAnswerException();
        }

        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }
}
