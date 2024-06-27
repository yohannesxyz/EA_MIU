package app;

import java.util.List;
import java.util.Optional;

import app.domain.Book;
import app.domain.Customer;
import app.repositories.BookRepository;
import app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// Create and save three books
		bookRepository.save(new Book("Book Title 1", "123-4567890123", "Author 1", 29.99));
		bookRepository.save(new Book("Book Title 2", "123-4567890124", "Author 2", 39.99));
		bookRepository.save(new Book("Book Title 3", "123-4567890125", "Author 3", 49.99));

		// Retrieve and display all books
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		List<Book> books = bookRepository.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

		// Update a book
		Optional<Book> bookOpt = bookRepository.findById(1);
		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			book.setPrice(34.99);
			bookRepository.save(book);
			System.out.println("Updated Book:");
			System.out.println(book);
			System.out.println();
		}

		// Delete a book (not the updated one)
		bookRepository.deleteById(2);

		// Retrieve and display all books again
		System.out.println("Books found with findAll() after update and delete:");
		System.out.println("-------------------------------");
		books = bookRepository.findAll();
		for (Book book : books) {
			System.out.println(book);
		}


	}
}
