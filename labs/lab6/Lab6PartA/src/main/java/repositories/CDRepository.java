package repositories;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Long>, JpaSpecificationExecutor<CD> {
    List<CD> findByArtistAndPriceLessThan(String artist, double price);
    List<CD> findByArtist(String artist);
    List<CD> findByArtistAndPriceGreaterThan(String artist, double price);
}
