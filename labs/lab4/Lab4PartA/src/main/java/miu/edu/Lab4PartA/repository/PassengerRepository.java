package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
