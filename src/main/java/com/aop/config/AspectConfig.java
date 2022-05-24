package com.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.aop.exception.TaskException;

@Aspect
@Configuration
public class AspectConfig {

	private Logger log = LoggerFactory.getLogger(AspectConfig.class);

	@Before(value = "execution(* com.aop.controller.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}

	@After(value = "execution(* com.aop.controller.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Complete execution of {}", joinPoint);
	}

	@Around(value = "execution(* com.aop.service.*.*(..))")
	public Object taskExceptionHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
			return proceedingJoinPoint.proceed();
		} catch (TaskException taskException) {
			log.info("TaskException HttpStatus code {}", taskException.getHttpStatus().value());
			log.info("TaskException Message {}", taskException.getMessage());
		}
		return null;
	}
}
