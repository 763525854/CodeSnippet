/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1;

import com.rhyme.headfirst.part1.behavior.FlyBehavior;
import com.rhyme.headfirst.part1.behavior.QuackBehavior;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public abstract class Duck {
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;

	abstract void display();

	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}
}
