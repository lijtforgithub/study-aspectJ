package com.ljt.study.aspect;

/**
 * @author LiJingTang
 * @version 2015年9月21日下午2:46:56
 */
public aspect Aspect {

	pointcut publicCall(): execution(public Object *(..));

	after() returning(Object o): publicCall() {
		System.out.println("Returned normally with " + o);
	}

	after() throwing(Exception e): publicCall() {
		System.out.println("Threw an exception: " + e);
	}

	after(): publicCall() {
		System.out.println("Returned or threw an Exception");
	}

	private pointcut HelloWorldPointCut(int i) : execution(* method(int)) && args(i);

	int around(int x) : HelloWorldPointCut(x) {
		System.out.println("Entering : " + thisJoinPoint.getSourceLocation());
		int newValue = proceed(x * 3);
		
		return newValue;
	}

}
