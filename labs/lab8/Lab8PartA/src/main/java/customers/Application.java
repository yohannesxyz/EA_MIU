package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//        // create customer
//		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
//		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
//		creditCard = new CreditCard("657483342", "Visa", "09/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
//		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		//get customers
//		System.out.println(customerRepository.findById(66).get());
//		System.out.println(customerRepository.findById(101).get());
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerRepository.findAll());
//		//update customer
//		customer = customerRepository.findById(101).get();
//		customer.setEmail("jd@gmail.com");
//		customerRepository.save(customer);
//		System.out.println("-----------find by phone ----------------");
//		System.out.println(customerRepository.findByPhone("0622341678"));
//		System.out.println("-----------find by email ----------------");
//		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
//		System.out.println("-----------find customers with a certain type of creditcard ----------------");
//		List<Customer> customers = customerRepository.findByCreditCardType("Visa");
//		for (Customer cust : customers){
//			System.out.println(cust);
//		}

		//test data for a few student and some address
		Student student = new Student(1, "John Doe", "0612345678", new Address("Main Street", "Amsterdam", "1234AB"));
		Student student1 = new Student(2, "Jane Doe", "0612345678", new Address("Main Street", "Amsterdam", "1234AB"));
		Student student2 = new Student(3, "James Doe", "0612345678", new Address("Main Street", "Amsterdam", "1234AB"));
		Student student3 = new Student(4, "Jill Doe", "0612345678", new Address("Main Street", "Amsterdam", "1234AB"));


		//add grades to students


		student.addGrade(new Grade("Math", "A+"));
		student.addGrade(new Grade("Science", "A"));
		student.addGrade(new Grade("History", "B-"));
		student1.addGrade(new Grade("Math", "A+"));
		student1.addGrade(new Grade("Science", "A"));
		student1.addGrade(new Grade("History", "B"));
		student2.addGrade(new Grade("Math", "A+"));
		student2.addGrade(new Grade("Science", "A"));
		student2.addGrade(new Grade("History", "B"));
		student3.addGrade(new Grade("Math", "A+"));
		student3.addGrade(new Grade("Science", "A"));
		student3.addGrade(new Grade("History", "B"));





		studentRepository.save(student);
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);

		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findByName("John Doe"));
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhone("0612345678"));
		System.out.println("-----------find by city ----------------");
		System.out.println(studentRepository.findByAddressCity("Amsterdam"));
		System.out.println("-----------find by subject ----------------");
		System.out.println(studentRepository.findByGradesCourseName("Math"));
		System.out.println("-----------find by grade ----------------");
		System.out.println(studentRepository.findByGradesCourseNameAndGradesGrade( "Math","A+"));
		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());






	}

}
