package miu.edu.Lab9PartA.domain;

public class Book {

    private String title;
    private String isbn;
    private String author;
    private double price;


    public Book(String title, String isbn, String author, double price) {

        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }


    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
    //toString method
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
