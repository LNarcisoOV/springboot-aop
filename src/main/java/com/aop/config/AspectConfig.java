package com.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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
		log.info("Complete execution ofß {}", joinPoint);
	}
}
