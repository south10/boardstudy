package me.south10.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by south10 on 2016-06-16.
 */
@Component
@Aspect
@Slf4j
public class SampleAdvice {
    @Before("execution(* me.south10.service.MessageService*.*(..))")
    public void startLog(JoinPoint jp){
        log.info("--------------------------------");
        log.info("--------------------------------");
        log.info(Arrays.toString(jp.getArgs()));
    }

    @Around("execution(* me.south10.service.MessageService*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        log.info(Arrays.toString(pjp.getArgs()));

        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
        log.info("=========================================");
        return result;
    }
}
