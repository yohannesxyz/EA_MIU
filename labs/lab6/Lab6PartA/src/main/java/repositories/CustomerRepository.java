package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAll();
    List<Customer> findByAddress_Zip(String zip);
    List<Customer> findByTheOrders_Orderlines_Product_Name(String productName);
    List<Customer> findByAddress_Country(String country);
}
