package lab8b.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Document
@Entity
public class Person {

//    @Id
    @Id
    private int id;
    private String firstName;
    private String lastName;

@OneToMany(cascade = CascadeType.ALL)
    List<Pet> pet = new ArrayList<>();
    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addPet(Pet p){
        pet.add(p);
    }
}
