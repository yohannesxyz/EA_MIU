package miu.edu.Lab4PartA.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Employee> employees= new ArrayList<>();

    public void addEmployee(Employee employee){
        employee.setDepartment(this);
        employees.add(employee);
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees.stream()
                .map(Employee::getEmployeeName)
                .collect(Collectors.joining(", ")) +
                '}';
    }


}
