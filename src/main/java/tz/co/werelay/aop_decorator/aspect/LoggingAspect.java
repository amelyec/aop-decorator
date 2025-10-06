package tz.co.werelay.aop_decorator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* tz.co.werelay.aop_decorator.service..*(..))")
    public void applicationPackagePointcut() {
        
    }

    @Around("applicationPackagePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        String method = joinPoint.getSignature().toShortString();
        logger.info("Entering: {}", method);

        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info("Exiting: {} executed in {} ms", method, executionTime);

        return proceed; 
        
    }


}
