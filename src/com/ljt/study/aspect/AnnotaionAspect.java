package com.ljt.study.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author LiJingTang
 * @version 2015年9月21日下午4:38:13
 */
@Aspect
public class AnnotaionAspect {
	
	@Pointcut("execution(* *(..))")
	public void pointcut() {}
	
	@Pointcut("cflow(pointcut()) && !within(AnnotaionAspect)")
	public void actuallyPoint() {}
	
	@Before("actuallyPoint()")
	public void before() {
	}
	
}