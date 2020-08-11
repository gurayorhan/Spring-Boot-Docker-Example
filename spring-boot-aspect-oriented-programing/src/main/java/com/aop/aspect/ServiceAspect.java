package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @After("execution(* com.aop.service.*.*(..))")
    public void sendAfter(JoinPoint joinPoint){
        System.out.println("2."+joinPoint.getSignature());
    }

    @Before("execution(* com.aop.service.*.*(..))")
    public void sendBefore(JoinPoint joinPoint){
        System.out.println("1."+joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.aop.service.*.*(..))", throwing = "ex")
    public void logError(Exception ex) {
        System.out.println(ex.toString());
    }

}
