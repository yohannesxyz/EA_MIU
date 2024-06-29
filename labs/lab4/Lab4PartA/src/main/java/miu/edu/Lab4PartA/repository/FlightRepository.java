package miu.edu.Lab4PartA.repository;

import miu.edu.Lab4PartA.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
