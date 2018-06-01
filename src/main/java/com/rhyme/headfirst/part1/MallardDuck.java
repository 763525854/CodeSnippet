/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1;

import com.rhyme.headfirst.part1.behavior.FlyBehavior;
import com.rhyme.headfirst.part1.behavior.implement.FlyWithWings;
import com.rhyme.headfirst.part1.behavior.implement.Quack;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	void display() {
		System.out.println("i am 绿头鸭");

	}
}
