package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("tax")
public class TaxServiceJmsSender implements IJMSSender{

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void sendJMSMessage(String text) {

        System.out.println("TaxServiceJmsSender: sending JMS message ="+text);
        jmsTemplate.convertAndSend("testQueue",text);
    }
}
