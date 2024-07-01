package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByStatus(String status);

    @Query("SELECT o.ordernr FROM Order o WHERE o.status = 'closed'")
    List<String> findOrderNumbersByStatusClosed();

    @Query("SELECT c.firstname, c.lastname FROM Customer c WHERE c.address.city = 'Amsterdam'")
    List<Object[]> findCustomerNamesInAmsterdam();

    @Query("SELECT o.ordernr FROM Order o WHERE o.customer.address.city = :city")
    List<String> findOrderNumbersByCustomerCity(@Param("city") String city);
}
