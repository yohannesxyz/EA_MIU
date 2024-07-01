package repositories;

import domain.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DVDRepository extends JpaRepository<DVD, Long> {
    List<DVD> findByName(String name);
}
