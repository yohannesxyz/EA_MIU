package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.LocalDate;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;


    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting to send a message");
        CustomerMessage customerMessage = new CustomerMessage(123456789, "John Doe", 1000.0);

        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(customerMessage);
//        sender.send("createAcc", message);
//        sender.send("depositMoney", message);
        sender.send("withdrawMoney", message);
        System.out.println("Message has been sent");
    }
}
