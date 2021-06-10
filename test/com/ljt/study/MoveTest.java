package com.ljt.study;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ljt.study.target.Animal;
import com.ljt.study.target.Bird;
import com.ljt.study.target.Snake;

/**
 * @author LiJingTang
 * @version 2015年9月21日下午3:28:00
 */
public class MoveTest {

	@Test
	public void testMethod() {
		List<Animal> animalList = new ArrayList<>(2);
		animalList.add(new Snake());
		animalList.add(new Bird());
		
		this.move(animalList);
	}
	
	private void move(List<Animal> animalList) {
		if (null == animalList || animalList.isEmpty()) {
			return;
		}
		
		for (Animal animal : animalList) {
			animal.move();
		}
	}
	
}
