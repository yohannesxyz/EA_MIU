package lab8b.repository;


import lab8b.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
