package customers;

import customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2PartAApplication implements CommandLineRunner {


 public ICustomerService customerService;

  @Autowired
public void setCustomerService(ICustomerService customerService) {
	this.customerService = customerService;
}

	public static void main(String[] args) {
		SpringApplication.run(Lab2PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

//		productService.addProduct("test@email.com", "test product");
  }


}
