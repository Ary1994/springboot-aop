package com.ary.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class GreetingAspect {

    private  Logger logger=LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.ary.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: "+method+" con los argumentos con los args "+args);

    }

    @After("execution(String com.ary.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: "+method+" con los argumentos con los args "+args);

    }

    @AfterReturning("execution(String com.ary.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues after returning: "+method+" con los argumentos con los args "+args);

    }

    @AfterThrowing("execution(String com.ary.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfterthrowing(JoinPoint joinPoint){
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues after throwing: "+method+" con los argumentos con los args "+args);

    }
    @Around("execution(String com.ary.curso.springboot.app.aop.springbootaop.services.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result=null;

        try {
            logger.info("Despues around: "+method+"() con los argumentos con los args "+args);
            result=joinPoint.proceed();
            logger.info("Despues around: "+method+"() con el return : "+result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del method "+ method+"()");
            throw e;
        }
        

    }



}
