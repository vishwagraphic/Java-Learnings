package com.viswa.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("com.viswa.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataConfig()")
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is Called with arguments - {}", joinPoint, joinPoint.getArgs() );
	}
	
	@After("com.viswa.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataConfig()")
	public void logMethodCalled(JoinPoint joinPoint) {
		logger.info("After Aspect - {} is executed", joinPoint);
	}
	
	
	
	@AfterThrowing(
				pointcut = "com.viswa.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataConfig()",
				throwing = "exception"
			)
	public void logMethodCalledAfterThrowing(JoinPoint joinPoint, Exception exception) {
		logger.info("After Throwing Aspect - {} has thrown an exception {}", joinPoint, exception);
	}
	
	@AfterReturning(
			pointcut = "com.viswa.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataConfig()",
			returning = "resultValue"
		)
		public void logMethodCalledAfterReturn(JoinPoint joinPoint, Object resultValue) {
			logger.info("After returning Aspect - {} has returned {}", joinPoint, resultValue);
		}
}
