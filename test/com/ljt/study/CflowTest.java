package com.ljt.study;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ljt.study.target.Cfow;

/**
 * @author LiJingTang
 * @version 2015年9月21日下午3:28:00
 */
public class CflowTest {

	private static Cfow cflow; 

	@BeforeClass
	public static void beforeClass() {
		cflow = new Cfow();
	}
	
	@Test
	public void testMethod() {
		cflow.bar();
		cflow.foo();
	}
	
}
