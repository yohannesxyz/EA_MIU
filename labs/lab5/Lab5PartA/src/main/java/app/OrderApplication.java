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
import java.util.Optional;

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


	Product product = new Cd("Hibernate 3", "Good book on Hibernate", 35.50, "Gavin King");

		OrderLine ol1 = new OrderLine();
ol1.setProduct(product);

		Product product2 = new Book( "The best of Queen", "Album from 1995", 12.98, 1234567890L);

		OrderLine ol2 = new OrderLine();
ol2.setProduct(product2);
		Order o1 = new Order();
		o1.setDate("12/10/06");
		o1.setOrdernr("234743");
		o1.setStatus("open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);

		Customer c1 = new Customer();
		c1.setFirstname("Frank");
		c1.setLastname("Brown");
		Address a = new Address();
		a.setCity("Fairfield");
//		a.setCountry("USA");
		a.setZip("52557");
		a.setStreet("street");
		c1.addOrder(o1);
		o1.setCustomer(c1);
		c1.setAddress(a);

		orderRepository.save(o1);


		Optional<Order> orderOpt = orderRepository.findById(1L);
		Order order = orderOpt.get();
		printOrder(order);
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderLines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}
	}
}
