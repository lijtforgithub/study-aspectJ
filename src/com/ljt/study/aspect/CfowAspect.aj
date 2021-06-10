package com.ljt.study.aspect;

/**
 * cfow()获取的是一个控制流程。他很少几乎不单独使用，一般与其他的pointcut 进行 &&运算。若要单独使用，一定要记得用!with()剔除asepct 本身。
 * 
 * @author LiJingTang
 * @version 2015年9月21日下午2:27:21
 */
public aspect CfowAspect {

	pointcut barPointcut() : execution(* bar(..));
	pointcut fooPointcut() : execution(* foo(..));
	pointcut barCflowPointcut() : cflow(barPointcut()) && !within(CfowAspect); //cflow的参数是一个pointcut aspectj是静态织入，所以他拦截的是字节码
	pointcut fooInBarPointcut() : barCflowPointcut() && fooPointcut() ; //获取bar流程内的foo方法调用
	
//	before() : barCflowPointcut() {  
//	   System.out.println("Enter:" + thisJoinPoint);  
//	}  
	before() : fooInBarPointcut() {  
		System.out.println("Enter:" + thisJoinPoint);  
	}
	
}
