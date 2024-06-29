package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer>{
}
