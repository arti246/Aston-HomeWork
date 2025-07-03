package HomeWork2;

public class Student {
    private String name;
    private String surname;
    private int clasNumber;
    private char clasName;
    private MyArrayList<Book> books;

    public Student(String name, String surname, int clasNumber, char clasName, MyArrayList<Book> books) {
        this.name = name;
        this.surname = surname;
        this.clasNumber = clasNumber;
        this.clasName = clasName;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getClasNumber() {
        return clasNumber;
    }

    public void setClasNumber(int clasNumber) {
        this.clasNumber = clasNumber;
    }

    public char getClasName() {
        return clasName;
    }

    public void setClasName(char clasName) {
        this.clasName = clasName;
    }

    public MyArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(MyArrayList<Book> books) {
        this.books = books;
    }
}
