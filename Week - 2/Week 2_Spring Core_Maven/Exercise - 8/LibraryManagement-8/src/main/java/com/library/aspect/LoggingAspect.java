package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    

    @Before("execution(* com.library.repository.BookRepository.*(..))")
    public void beforeLogging(JoinPoint jp)  {
        System.out.println("Method "+jp.getSignature().getName()+" is invoked");
    }

    @After("execution(* com.library.repository.BookRepository.*(..))")
    public void afterLogging(JoinPoint jp){
        System.out.println("Method "+jp.getSignature().getName()+" is executed");

    }


}
