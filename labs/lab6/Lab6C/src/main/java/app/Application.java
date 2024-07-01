package app;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private SchoolRepository schoolRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		insertCustomers();
		retrieveCustomers();
		updateCustomers();
		insertSchools();
		retrieveSchoolsWithoutStudents();
		retrieveSchoolsWithStudents();
	}

	@Transactional
	public void insertCustomers() {
		int batchSize = 50;
		for (int x = 0; x < 5000; x++) {
			Customer customer = new Customer("John Doe " + x);
			Account account = new Account("123" + x);
			customer.setAccount(account);
			customerRepository.save(customer);
			if (x % batchSize == 0 && x > 0) {
				entityManager.flush();
				entityManager.clear();
			}
			System.out.println("Inserting customer " + x);
		}
	}

	private void retrieveCustomers() {
		System.out.println("Retrieving all customers ...");
		long start = System.currentTimeMillis();

		List<Customer> customers = customerRepository.findAll();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all Customers took " + timeElapsed + " ms");
	}

	private void updateCustomers() {
		System.out.println("Change the name of all customers ...");
		long start = System.currentTimeMillis();

		int updatedCount = customerRepository.updateCustomerNames("James Bond");

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To change the name of all customers took " + timeElapsed + " ms");
		System.out.println("Updated " + updatedCount + " customers");
	}

	@Transactional
	public void insertSchools() {
		int batchSize = 50;
		for (int i = 0; i < 100; i++) {
			School school = new School("School " + i);
			for (int j = 0; j < 200; j++) {
				Student student = new Student("FirstName " + j, "LastName " + j, "email" + j + "@school.com");
				school.addStudent(student);
			}
			schoolRepository.save(school);
			if (i % batchSize == 0 && i > 0) {
				entityManager.flush();
				entityManager.clear();
			}
			System.out.println("Inserting school " + i);
		}
	}

	private void retrieveSchoolsWithoutStudents() {
		System.out.println("Retrieving all schools without students ...");
		long start = System.currentTimeMillis();

		List<School> schools = schoolRepository.findAll();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all Schools without students took " + timeElapsed + " ms");
		for (School school : schools) {
			System.out.println("School: " + school.getName());
		}
	}

	private void retrieveSchoolsWithStudents() {
		System.out.println("Retrieving all schools with students ...");
		long start = System.currentTimeMillis();

		List<School> schools = schoolRepository.findAll();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all Schools with students took " + timeElapsed + " ms");
		for (School school : schools) {
			System.out.println("School: " + school.getName());
			for (Student student : school.getStudents()) {
				System.out.println(" - Student: " + student.getFirstName() + " " + student.getLastName());
			}
		}
	}
}
