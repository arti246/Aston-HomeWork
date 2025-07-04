package HomeWork2;

public class Book {
    private String name;
    private int year;
    private String author;
    private int countPage;

    public Book(String name, String author, int year, int countPage) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.countPage = countPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", countPage=" + countPage +
                '}';
    }
}
