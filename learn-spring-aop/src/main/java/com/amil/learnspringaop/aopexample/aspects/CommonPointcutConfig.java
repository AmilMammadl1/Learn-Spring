package com.amil.learnspringaop.aopexample.aspects;

import com.amil.learnspringaop.aopexample.annotations.TrackTime;
import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    @Pointcut("execution(* com.amil.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}
    @Pointcut("@annotation(com.amil.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){}



}
