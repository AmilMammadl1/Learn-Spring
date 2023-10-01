package com.amil.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//this is configuration class which contains AOP configuration
//@Configuration
//@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Before("com.amil.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        logger.info("Before Aspect - method is called {}", joinPoint);
    }
    @After("com.amil.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect - method is called {}", joinPoint);
    }
    @AfterReturning(pointcut = "com.amil.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",returning = "resultVal")
    public void logMethodCallAfterReturingExecution(JoinPoint joinPoint,Object resultVal){
        logger.info("After Returning Aspect - method is called {}", joinPoint);
    }
    @AfterThrowing(pointcut = "com.amil.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",throwing = "exception")
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint,Exception exception){
        logger.info("AfterThrowing Aspect - method is called {}", joinPoint);
    }
}
