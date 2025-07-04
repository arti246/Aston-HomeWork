package HomeWork2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Book> books = new MyArrayList<>(10);
        MyHashSet<Student> students = new MyHashSet<>(16);
        addBook(books);
        addStudents(students, books);

        students.stream()
                .peek(student -> System.out.println(student))
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getCountPage)
                        .thenComparing(Book::getName)
                        .thenComparing(Book::getAuthor))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.println("Год выпуска найденной книги: " + book.getYear()),
                        () -> System.out.println("Книга, соответствующая условиям, отсутствует")
                );

    }

    private static void addBook(MyArrayList<Book> books) {
        books.myAdd(new Book("Война и мир", "Лев Толстой", 1869 , 1225));
        books.myAdd(new Book("1984", "Джордж Оруэлл", 1949 , 328));
        books.myAdd(new Book("Улисс", "Джеймс Джойс", 1922 , 704));
        books.myAdd(new Book("Гарри Поттер 1", "Джоан Роулинг", 1997 , 320));
        books.myAdd(new Book("Мастер и Маргарита", "Лев Толстой", 1967 , 564));
        books.myAdd(new Book("Код да Винчи", "Дэн Браун", 2003 , 480));
        books.myAdd(new Book("Девушка с татуировкой дракона", "Стиг Ларссон", 2005 , 560));
        books.myAdd(new Book("Исчезнувшая", "Гиллиан Флинн", 2012 , 415));
        books.myAdd(new Book("Тёмные начала", "Филип Пулман", 2000 , 399));
        books.myAdd(new Book("451° по Фаренгейту (переиздание)", "Рэй Брэдбери", 2013 , 256));
    }

    private static void addStudents(MyHashSet<Student> students, MyArrayList<Book> books) {
        String[] names = {"Иванов Иван", "Петров Пётр", "Сергеев Сергей",
                "Анатольев Анатолий", "Катина Екатерина",
                "Окаснова Оксана", "Евкакьев Евкакий"};

        for (String name : names) {
            Student student = new Student(name, 1 + (int) (Math.random() * 11));
            MyArrayList<Book> bookArrayList = new MyArrayList<>();

            // Создаем список доступных индексов книг
            List<Integer> availableBookIndices = new ArrayList<>();
            for (int i = 0; i < books.getSize(); i++) {
                availableBookIndices.add(i);
            }

            // Перемешиваем индексы для случайного выбора
            Collections.shuffle(availableBookIndices);

            // Добавляем 5 уникальных книг
            for (int i = 0; i < 5 && i < availableBookIndices.size(); i++) {
                bookArrayList.myAdd(books.myGet(availableBookIndices.get(i)));
            }

            student.setBooks(bookArrayList);
            students.myAdd(student);
        }
    }
}
