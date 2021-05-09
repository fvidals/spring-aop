package dev.fvidals.spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeElapsedAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TimeElapsedAdvice.class);

    @Pointcut("@annotation(timeElapsed)")
    public void timeElapsed(TimeElapsed timeElapsed) {
    }

    @Around("timeElapsed(timeElapsed)")
    public Object timeElapsed(ProceedingJoinPoint joinPoint, TimeElapsed timeElapsed) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long finish = System.currentTimeMillis();
        long diff = finish - start;

        logger.info(String.format("AspectJ timeElapsed: %s %dms", joinPoint.getSignature().getName(), diff));

        return result;
    }
}
