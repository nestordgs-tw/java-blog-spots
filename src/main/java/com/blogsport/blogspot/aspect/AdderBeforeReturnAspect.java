package com.blogsport.blogspot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdderBeforeReturnAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // @TODO: Ejemplo Aspect en metodos sin parametros antes de su ejecucion en service
    @Before("execution(* com.blogsport.blogspot.service.*.*())")
    public void logMethodExampleWithoutParms(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        logger.info("Executing method without: " + methodName);
    }

    // @TODO: Ejemplo Aspect en metodos con parametros parametros antes de su ejecucion en service
    @Before("execution(* com.blogsport.blogspot.service.*.*(..)) and args(*)")
    public void logMethodExampleWithParams(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        logger.info("Executing method with: " + methodName);
    }
}
