package customers.aop;

import customers.integration.impl.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class EmailSenderAdvice {

    @After("execution(* customers.integration.impl.EmailSender.sendEmail(..)) && args(email, message)")
    public void sendEmailAdvice(JoinPoint joinPoint,String email,String message){

        EmailSender emailSender = (EmailSender) joinPoint.getTarget();
        System.out.println(LocalDateTime.now()+
                " method="+joinPoint.getSignature().getName()
                + " Address="+email
                + " message="+message
                + " outgoingMailServer="+emailSender.getOutgoingMailServer()
        );

    }
}
