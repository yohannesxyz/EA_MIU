package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@ComponentScan("repositories") // Add this line to ensure component scanning for repositories
public class OrderApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderLineRepository orderLineRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		// Create a list of order lines
//		List<OrderLine> orderLines = new ArrayList<>();
//		orderLines.add(orderLine1);
//
		// Create a customer with an address
		Customer customer = new Customer();
		customer.setFirstname("John");
		customer.setLastname("Doe");

		Address address = new Address();
		address.setCity("New York");
		address.setStreet("5th Avenue");
		address.setZip("10001");
		customer.setAddress(address);

		// Associate the customer with the order
		customerRepository.save(customer); // Save customer first to generate ID
		customer = customerRepository.findById(customer.getId()).orElse(null); // Re-fetch customer to ensure it's managed

		// Create an order and associate with customer and order lines
		Order order = new Order();
		order.setDate("2024-06-27");
		order.setOrdernr("12345");
		order.setStatus("Confirmed");
		order.setCustomer(customer);
		// Create a product
		Product product1 = new Product();
		product1.setName("Hibernate 3");
		product1.setDescription("Good book on Hibernate");
		product1.setPrice(29.99);
		productRepository.save(product1);

		// Create an order line with the product
		OrderLine orderLine1 = new OrderLine();
		orderLine1.setProduct(product1);
		orderLine1.setQuantity(2);


		order.addOrderLine(orderLine1);

		orderRepository.save(order);
		orderLineRepository.save(orderLine1);
	}
}
