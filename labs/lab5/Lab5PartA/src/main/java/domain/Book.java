package domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Book extends Product{
    private Long isbn;

    public Book(String name, String description, double price, Long isbn) {
        super(name, description, price);
        this.isbn = isbn;
    }
}
