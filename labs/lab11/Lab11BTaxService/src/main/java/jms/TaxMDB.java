package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLOutput;

@Component
public class TaxMDB {
 
    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String msg) {
        System.out.println("Received message: " + msg);
     }
}

