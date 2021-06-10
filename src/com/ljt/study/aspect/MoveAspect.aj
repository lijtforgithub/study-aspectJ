package com.ljt.study.aspect;

import com.ljt.study.MoveTest;
import com.ljt.study.target.Animal;

/**
 * target()获取继承关系
 * @author LiJingTang
 * @version 2015年9月21日下午3:46:31
 */
public aspect MoveAspect {

	/*private pointcut MovePointcut() : call(* move(..)) && target(Animal) && this(MoveTest);
	
	before() : MovePointcut() {
		System.out.println("Entering " + thisJoinPoint.getSourceLocation());
	}*/
	
	private pointcut MovePointcut(Animal aniaml, MoveTest test) : call(* move(..)) && target(aniaml) && this(test);
	
	before(Animal aniaml, MoveTest test) : MovePointcut(aniaml, test) {
		System.out.println("Entering " + thisJoinPoint.getSourceLocation() + "  target:" + aniaml + "  this:" + test);
	}

}
