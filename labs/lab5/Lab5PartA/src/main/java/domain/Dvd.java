package domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity

@NoArgsConstructor
//@AllArgsConstructor
public class Dvd extends Product{
    private String genre;

    // generate constructor with product
    public Dvd(String name, String description, double price, String genre) {
        super(name, description, price);
        this.genre = genre;
    }

    public Dvd(String genre) {
        this.genre = genre;
    }
}
