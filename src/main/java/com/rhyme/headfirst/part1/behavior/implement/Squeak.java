/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1.behavior.implement;

import com.rhyme.headfirst.part1.behavior.QuackBehavior;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月9日
 */
public class Squeak implements QuackBehavior{

	/* (non-Javadoc)
	 * @see com.rhyme.headfirst.part1.behavior.QuackBehavior#quack()
	 */
	@Override
	public void quack() {
		System.out.println("吱吱吱");
	}

}
