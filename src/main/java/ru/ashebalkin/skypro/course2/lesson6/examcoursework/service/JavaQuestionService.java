package ru.ashebalkin.skypro.course2.lesson6.examcoursework.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.AllReadyHaveAnswerException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionAllReadyExistException;
import ru.ashebalkin.skypro.course2.lesson6.examcoursework.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();

        questions.add(new Question("Почему Java не на 100% объектно-ориентирована",
                "Потому что в ней используются восемь примитивных типов данных, таких как boolean, byte, char, int, float, double, long, short, которые не являются объектами"));
        questions.add(new Question("Что такое классы-оболочки",
                "ЭКлассы-оболочки преобразуют примитивы в ссылочные типы (объекты)"));
        questions.add(new Question("Что такое конструкторы?",
                "Относится к блоку кода, который используется для инициализации объекта. Он должен иметь то же имя, что и класс. Кроме того, он не имеет возвращаемого типа и автоматически вызывается при создании объекта"));
        questions.add(new Question("Что такое одноэлементный класс и как мы можем сделать его?",
                "Класс Singleton – это класс, только один экземпляр которого может быть создан в любой момент времени в одной JVM. Класс можно сделать одноэлементным, сделав его конструктор закрытым"));
        questions.add(new Question("Что такое объектно-ориентированное программирование?",
                "Объектно-ориентированное программирование или широко известное как ООП – это модель программирования или подход, при котором программы организованы вокруг объектов, а не логики и функций."));
        questions.add(new Question("В чем разница между equals() и ==?",
                "Метод Equals() определен в классе Object и используется для проверки равенства двух объектов, определенных бизнес-логикой. «==» или оператор равенства – это бинарный оператор, предоставляемый языком программирования Java и используемый для сравнения примитивов и объектов"));
        questions.add(new Question("Почему Java не зависит от платформы?",
                "Java называется платформо-независимой из-за ее байтовых кодов, которые могут работать в любой системе, независимо от базовой операционной системы"));
        questions.add(new Question("Что такое модификаторы доступа?",
                "Модификаторы доступа – это специальные ключевые слова, которые используются для ограничения доступа класса, конструктора, элемента данных и метода в другом классе"));
        questions.add(new Question("Определение класса",
                "Класс – это план, который включает все ваши данные. Класс содержит поля (переменные) и методы для описания поведения объекта. Давайте посмотрим на синтаксис класса."));
        questions.add(new Question("Что такое объект и как он создается?",
                "Объект – это реальный объект, у которого есть состояние и поведение"));
    }

    @Override
    public Question add(String question, String answer) {
        return new Question(question, answer);
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

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questionsForPrint = new ArrayList<>(questions);
        Random random = new Random();
        return questionsForPrint.get(random.nextInt(questionsForPrint.size()-1));
    }

}
