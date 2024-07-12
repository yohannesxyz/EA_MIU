package miu.edu.Lab14A.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;
    private String name;
    private String title;
    private String email;
    private String phone;
    private String address;
    @ManyToOne
    private Department department;
}
