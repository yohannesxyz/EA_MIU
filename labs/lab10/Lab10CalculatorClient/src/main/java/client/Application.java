package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CalculatorClient calculatorClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int a = 10;
		int b = 20;
		System.out.println("Addition of " + a + " and " + b + " is " + calculatorClient.add(a, b));
		System.out.println("Subtraction of " + a + " and " + b + " is " + calculatorClient.subtract(a, b));
		System.out.println("Multiplication of " + a + " and " + b + " is " + calculatorClient.multiply(a, b));
	}

}


