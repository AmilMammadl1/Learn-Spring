package com.amil.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Around("com.amil.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object FindExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;
        logger.info("Araund Aspect - {} Method is executed in {}",proceedingJoinPoint,executionDuration);
        return returnValue;

    }
}
