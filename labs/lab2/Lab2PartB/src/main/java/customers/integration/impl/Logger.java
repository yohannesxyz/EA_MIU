package customers.integration.impl;

import customers.integration.ILogger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Logger implements ILogger {

	public void log(String logstring) {
		System.out.println("Logging "+LocalDateTime.now()+" "+logstring);		
	}

}
