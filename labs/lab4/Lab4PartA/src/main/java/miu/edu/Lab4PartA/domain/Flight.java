package miu.edu.Lab4PartA.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightNumber;
    @Column(name = "departure_city")
    private String from;
    @Column(name = "arrival_city")
    private String to;
    private LocalDate date;
}
