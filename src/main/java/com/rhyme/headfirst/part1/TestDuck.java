/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public class TestDuck {
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.display();
		duck.performFly();
		duck.performQuack();
	}
}
