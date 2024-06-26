package bank.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class DaoAspect {
    @Autowired
    Logger logger;

    @After("execution(* bank.dao.*.*(..))")
    public void logDaoAccess(JoinPoint joinPoint) {
        logger.log("Access time= "+ LocalDateTime.now()+"Dao method accessed: "
                + joinPoint.getSignature().getName()
               + " called by "+joinPoint.getTarget() );
    }
}
