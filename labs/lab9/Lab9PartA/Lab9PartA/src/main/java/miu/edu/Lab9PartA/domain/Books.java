package miu.edu.Lab9PartA.domain;

import java.util.Collection;

public class Books {
    private Collection<Book> books;
    public Books(Collection<Book> books) {
        this.books = books;
    }
    public Collection<Book> getBooks() {
        return books;
    }
    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
    public Books() {
    }
    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }
}
