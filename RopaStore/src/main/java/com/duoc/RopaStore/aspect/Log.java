package com.duoc.RopaStore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {

    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    @Before("execution(* com.duoc.RopaStore.service..*(..))")
    public void logAntes(JoinPoint joinPoint) {
        logger.info("Ejecutando: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.duoc.RopaStore.service..*(..))", returning = "resultado")
    public void logDespues(JoinPoint joinPoint, Object resultado) {
        logger.info("Finalizado: {} - resultado: {}", joinPoint.getSignature().toShortString(), resultado);
    }

    @AfterThrowing(pointcut = "execution(* com.duoc.RopaStore.service..*(..))", throwing = "excepcion")
    public void logError(JoinPoint joinPoint, Exception excepcion) {
        logger.error("Error en: {} - mensaje: {}", joinPoint.getSignature().toShortString(), excepcion.getMessage());
    }
}