package com.viswa.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspects {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("com.viswa.learnspringaop.aopexample.aspects.CommonPointCutConfig.businessAndDataConfig()")
	public Object findExecutionTime(ProceedingJoinPoint joinPoint) {
		long startTimeMillis = System.currentTimeMillis();
		logger.info("startTimeMillis {}", startTimeMillis);
		
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long stopTimeMillis = System.currentTimeMillis();
		logger.info("stopTimeMillis {}", stopTimeMillis);
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		
		logger.info("Around aspect Medthod {}, executionDuration {}", joinPoint, executionDuration);
		
		return returnValue;
	}
}
