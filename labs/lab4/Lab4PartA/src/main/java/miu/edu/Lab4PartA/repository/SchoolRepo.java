package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Integer> {
}
