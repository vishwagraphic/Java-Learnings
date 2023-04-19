package com.viswa.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

	@Pointcut("execution(* com.viswa.learnspringaop.aopexample.*.*.*(..))")
	public void businessAndDataConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void dataPackageConfig() {}
}
