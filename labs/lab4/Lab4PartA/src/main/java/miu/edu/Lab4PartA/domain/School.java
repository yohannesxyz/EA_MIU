package miu.edu.Lab4PartA.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

//create attributes id and name
@Entity
@NoArgsConstructor
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "school_id")
    @MapKey(name = "studentId")
    private Map<Integer, Student> students = new HashMap<Integer,Student>();

    //create constructor
    public School( String name) {

        this.name = name;
    }

    //create getter and setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
