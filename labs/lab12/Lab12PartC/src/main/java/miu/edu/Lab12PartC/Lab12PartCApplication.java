package miu.edu.Lab12PartC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@Validated
public class Lab12PartCApplication implements CommandLineRunner{
@Autowired
private ApplicationProperties applicationProperties;
	public static void main(String[] args) {
		SpringApplication.run(Lab12PartCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
applicationProperties.print();
	}
}
