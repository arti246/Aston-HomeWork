package HomeWork2;

public class Student {
    private String name;
    private int clasNumber;
    private MyArrayList<Book> books;

    public Student(String name, int clasNumber) {
        this.clasNumber = clasNumber;
        this.name = name;
    }

    public Student(String name, int clasNumber, MyArrayList<Book> books) {
        this.name = name;
        this.clasNumber = clasNumber;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClasNumber() {
        return clasNumber;
    }

    public void setClasNumber(int clasNumber) {
        this.clasNumber = clasNumber;
    }

    public MyArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(MyArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(", ").append(clasNumber).append(" класс");
        return stringBuilder.toString();
    }
}
