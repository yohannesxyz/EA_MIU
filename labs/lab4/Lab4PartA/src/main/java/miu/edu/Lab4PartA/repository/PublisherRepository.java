package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
