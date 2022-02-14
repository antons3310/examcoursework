package ru.ashebalkin.skypro.course2.lesson6.examcoursework.constants;

import ru.ashebalkin.skypro.course2.lesson6.examcoursework.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExamTestConstants {
    public static final Question JAVA_ETALON_QUESTION = new Question("Что такое Java", "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems");
    public static final Question MATH_ETALON_QUESTION = new Question("Первая координата точки?", "Абсцисса");
    public static final String JAVA_RIGHT_QUESTION_TEXT = "Что такое Java";
    public static final String MATH_RIGHT_QUESTION_TEXT = "Первая координата точки?";
    public static final String JAVA_RIGHT_ANSWER_TEXT = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems";
    public static final String MATH_RIGHT_ANSWER_TEXT = "Абсцисса";
    public static final String JAVA_WRONG_QUESTION_TEXT = "Python";
    public static final String MATH_WRONG_QUESTION_TEXT = "Ордината";
    public static final Question DUBLICATE_QUESTION = new Question("Этот вопрос уже задавался", "Этот ответ уже был дан");
    public static final Question DUBLICATE_QUESTION_QUESTIONTEXT = new Question("Тут пишем текст вопроса", "Здесь на вопрос отвечаем");
    public static final Question DUBLICATE_QUESTION_QUESTIONTEXT_ANOTHER_ANSWER = new Question("Тут пишем текст вопроса", "На этот вопрос нет ответа");
    public static final Question QUESTION_TO_REMOVE = new Question("Вопрос для удаления", "Этот ответ уже был дан");
    public static final int QUESTIONS_COUNT = 8;
    public static final int NOT_ENOUGHT_QUESTION_COUNT = 40;
    public static final Question JAVA_ETALON_QUESTION_1 = new Question("Что такое Java", "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems");
    public static final Question JAVA_ETALON_QUESTION_2 = new Question("Что такое классы-оболочки", "ЭКлассы-оболочки преобразуют примитивы в ссылочные типы (объекты)");
    public static final Question JAVA_ETALON_QUESTION_3 = new Question("Что такое конструкторы?", "Относится к блоку кода, который используется для инициализации объекта. Он должен иметь то же имя, что и класс. Кроме того, он не имеет возвращаемого типа и автоматически вызывается при создании объекта");
    public static final Question JAVA_ETALON_QUESTION_4 = new Question("Что такое объект и как он создается?", "Объект – это реальный объект, у которого есть состояние и поведение");
    public static final Question MATH_ETALON_QUESTION_1 = new Question("Сотая часть числа?", "Процент");
    public static final Question MATH_ETALON_QUESTION_2 = new Question("Что легче: 1 кг ваты или 1 кг железа?", "Одинаково");
    public static final Question MATH_ETALON_QUESTION_3 = new Question("Может ли при умножении получиться ноль?", "Да");
    public static final Question MATH_ETALON_QUESTION_4 = new Question("Чему равна четверть часа?", "15 минут");

    public static final Collection<Question> JAVA_QUESTION_COLLECTION = new ArrayList<>(List.of(
            new Question("Почему Java не на 100% объектно-ориентирована",
                    "Потому что в ней используются восемь примитивных типов данных, таких как boolean, byte, char, int, float, double, long, short, которые не являются объектами"),
            new Question("Что такое классы-оболочки",
                    "ЭКлассы-оболочки преобразуют примитивы в ссылочные типы (объекты)"),
            new Question("Что такое конструкторы?",
                    "Относится к блоку кода, который используется для инициализации объекта. Он должен иметь то же имя, что и класс. Кроме того, он не имеет возвращаемого типа и автоматически вызывается при создании объекта"),
            new Question("Что такое одноэлементный класс и как мы можем сделать его?",
                    "Класс Singleton – это класс, только один экземпляр которого может быть создан в любой момент времени в одной JVM. Класс можно сделать одноэлементным, сделав его конструктор закрытым"),
            new Question("Что такое объектно-ориентированное программирование?",
                    "Объектно-ориентированное программирование или широко известное как ООП – это модель программирования или подход, при котором программы организованы вокруг объектов, а не логики и функций."),
            new Question("В чем разница между equals() и ==?",
                    "Метод Equals() определен в классе Object и используется для проверки равенства двух объектов, определенных бизнес-логикой. «==» или оператор равенства – это бинарный оператор, предоставляемый языком программирования Java и используемый для сравнения примитивов и объектов"),
            new Question("Почему Java не зависит от платформы?",
                    "Java называется платформо-независимой из-за ее байтовых кодов, которые могут работать в любой системе, независимо от базовой операционной системы"),
            new Question("Что такое модификаторы доступа?",
                    "Модификаторы доступа – это специальные ключевые слова, которые используются для ограничения доступа класса, конструктора, элемента данных и метода в другом классе"),
            new Question("Определение класса",
                    "Класс – это план, который включает все ваши данные. Класс содержит поля (переменные) и методы для описания поведения объекта. Давайте посмотрим на синтаксис класса."),
            new Question("Что такое объект и как он создается?",
                    "Объект – это реальный объект, у которого есть состояние и поведение")
    ));

    public static final Collection<Question> MATH_QUESTION_COLLECTION = new ArrayList<>(List.of(
            new Question("Сотая часть числа?",
                    "Процент"),
            new Question("Что легче: 1 кг ваты или 1 кг железа?",
                    "Одинаково"),
            new Question("Может ли при умножении получиться ноль?",
                    "Да"),
            new Question("Чему равна четверть часа?",
                    "15 минут"),
            new Question("Специфическая единица измерения объёма нефти?",
                    "Баррель."),
            new Question("Первая координата точки?",
                    "Абсцисса"),
            new Question("Наука, изучающая свойства фигур на плоскости?",
                    "Планиметрия"),
            new Question("Прибор для измерения углов?",
                    "Транспортир"),
            new Question("Учёный, наиболее известным достижением которого стало «решето» для отсеивания простых чисел?",
                    "Эратосфен"),
            new Question("Утверждение, требующее доказательства?",
                    "Теорема")
    ));

    public static final Collection<Question> JAVA_EXPECTED_QUESTIONS = new ArrayList<>(List.of(
            new Question("Что такое Java",
                    "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems"),
            new Question("Что такое классы-оболочки",
                    "ЭКлассы-оболочки преобразуют примитивы в ссылочные типы (объекты)"),
            new Question("Что такое конструкторы?",
                    "Относится к блоку кода, который используется для инициализации объекта. Он должен иметь то же имя, что и класс. Кроме того, он не имеет возвращаемого типа и автоматически вызывается при создании объекта"),
            new Question("Что такое объект и как он создается?",
                    "Объект – это реальный объект, у которого есть состояние и поведение")
    ));

    public static final Collection<Question> MATH_EXPECTED_QUESTIONS = new ArrayList<>(List.of(
            new Question("Сотая часть числа?",
                    "Процент"),
            new Question("Что легче: 1 кг ваты или 1 кг железа?",
                    "Одинаково"),
            new Question("Первая координата точки?",
                    "Абсцисса"),
            new Question("Чему равна четверть часа?",
                    "15 минут")
    ));

    public static final Collection<Question> BOTH_EXPECTED_QUESTIONS = new ArrayList<>(List.of(
            new Question("Сотая часть числа?",
                    "Процент"),
            new Question("Что легче: 1 кг ваты или 1 кг железа?",
                    "Одинаково"),
            new Question("Может ли при умножении получиться ноль?",
                    "Да"),
            new Question("Чему равна четверть часа?",
                    "15 минут"),
            new Question("Что такое Java",
                    "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems"),
            new Question("Что такое классы-оболочки",
                    "ЭКлассы-оболочки преобразуют примитивы в ссылочные типы (объекты)"),
            new Question("Что такое конструкторы?",
                    "Относится к блоку кода, который используется для инициализации объекта. Он должен иметь то же имя, что и класс. Кроме того, он не имеет возвращаемого типа и автоматически вызывается при создании объекта"),
            new Question("Что такое объект и как он создается?",
                    "Объект – это реальный объект, у которого есть состояние и поведение")
    ));


    public static final Collection<Question> UNEXPECTED_QUESTIONS = new ArrayList<>(List.of(
            new Question("Что такое объект и как он создается?",
                    "Объект – это реальный объект, у которого есть состояние и поведение")
    ));
}
