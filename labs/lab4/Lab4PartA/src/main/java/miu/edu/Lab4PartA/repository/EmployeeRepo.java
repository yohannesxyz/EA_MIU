package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
