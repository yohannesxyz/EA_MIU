package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
