package miu.edu.Lab4PartA;

import miu.edu.Lab4PartA.domain.*;
import miu.edu.Lab4PartA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Lab4PartAApplication implements CommandLineRunner {

	@Autowired
	DepartmentRepo departmentRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	SchoolRepo schoolRepo;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab4PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setEmployeeName("John");
//		Department department = new Department();
//		department.setName("IT");
//		department.addEmployee(employee);
//
//		departmentRepo.save(department);
//		employeeRepo.save(employee);
//		System.out.println(departmentRepo.findAll());
//
//
//		Student student1 = new Student("John", "Doe");
//		studentRepo.save(student1);
//
//		School school = new School("ABC University");
//		school.getStudents().put(student1.getStudentId(), student1);
//		schoolRepo.save(school);


//		// Create a publisher
//		Publisher publisher = new Publisher();
//		publisher.setName("O'Reilly Media");
//
//		publisherRepository.save(publisher);
//
//		// Create a book with a publisher
//		Book bookWithPublisher = new Book();
//		bookWithPublisher.setTitle("Learning Spring Boot");
//		bookWithPublisher.setAuthor("Greg L. Turnquist");
//		bookWithPublisher.setPublisher(publisher);
//
//		bookRepository.save(bookWithPublisher);
//
//		// Create a book without a publisher
//		Book bookWithoutPublisher = new Book();
//		bookWithoutPublisher.setTitle("Effective Java");
//		bookWithoutPublisher.setAuthor("Joshua Bloch");
//
//		bookRepository.save(bookWithoutPublisher);

		// Create some flights
		Flight flight1 = new Flight(0, "AA123", "New York", "Los Angeles", LocalDate.of(2023, 7, 15));
		Flight flight2 = new Flight(0, "BA456", "London", "New York", LocalDate.of(2023, 7, 20));
		Flight flight3 = new Flight(0, "CA789", "San Francisco", "Tokyo", LocalDate.of(2023, 7, 25));

		// Save flights (if you have cascading, you might not need this step)
		flight1 = flightRepository.save(flight1);
		flight2 = flightRepository.save(flight2);
		flight3 = flightRepository.save(flight3);

		// Create a passenger with flights
		Passenger passenger = new Passenger();
		passenger.setName("John Doe");
		passenger.setFlights(Arrays.asList(flight1, flight2, flight3));

		// Save passenger
		passengerRepository.save(passenger);

	}
}
