package bank.integration.kafkaMessaging;

import bank.service.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class DepositMoneyReciever {
    @Autowired
    private IAccountService accountService;

    @KafkaListener(topics = {"depositMoney"})
    public void receive(@Payload String incomingMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            CustomerMessage message = objectMapper.readValue(incomingMessage, CustomerMessage.class);

            accountService.deposit(message.getAccountNumber(), message.getAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
