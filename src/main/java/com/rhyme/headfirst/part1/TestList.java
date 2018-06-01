/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1;

import java.util.List;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public class TestList {
	public static void main(String[] args) {
		TeacherA teacherA = new TeacherA();
		teacherA.setString("sadfas");
		teacherA.setHaha(null);
		List<String> test = teacherA.getHaha();
		if (test == null) {
			System.out.println("sada");
		} else {
			System.out.println("safdsa");
		}
	}
}
