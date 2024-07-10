package bank.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class JmsAspect {
    @Autowired
    Logger logger;
    @AfterReturning("execution(* bank.integration.jms.JMSSender.sendJMSMessage(..))&& args(text)")
    public void logJmsAccess(JoinPoint joinPoint, String text){
        logger.log(LocalDateTime.now()+"JMS message sent message= "+text);
    }

}
