package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
