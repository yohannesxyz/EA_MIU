package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Cd extends Product{

    public Cd(String name, String description, double price, String artist) {
        super(name, description, price);
        this.artist = artist;
    }

    private String artist;
}
