package com.ljt.study.aspect;

import com.ljt.study.target.Within;

/**
 * @author LiJingTang
 * @version 2015年9月21日下午2:26:03
 */
public aspect HelloWorldAspect {

	/*pointcut HelloWorldPointCut(int i) : execution(* com.ljt.target.HelloWorld.main(int)) && args(i);
	
	before(int x) : HelloWorldPointCut(x) {
		x += 5;
		System.out.println("in the aspect i = " +x);  
	}*/
	
	pointcut HelloWorldPointCut() : call(* main(..)) && !within(Within); // 调用的地方
//	pointcut HelloWorldPointCut() : execution(* main(int)); // 执行的地方
	
	before() : HelloWorldPointCut() {
		 System.out.println("Entering : " + thisJoinPoint.getSourceLocation());  
	}
	
}
