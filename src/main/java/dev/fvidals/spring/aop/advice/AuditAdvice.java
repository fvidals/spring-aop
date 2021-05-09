package dev.fvidals.spring.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditAdvice {

    private static final Logger logger = LoggerFactory.getLogger(AuditAdvice.class);

    @Before("@annotation(audit)")
    public void audit(JoinPoint joinPoint, Audit audit) {
        if (!audit.isEnabled()) {
            return;
        }

        logger.info("AspectJ audit: " + joinPoint.getSignature().getName());
    }
}
