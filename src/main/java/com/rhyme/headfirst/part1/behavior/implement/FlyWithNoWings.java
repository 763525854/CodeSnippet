/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1.behavior.implement;

import com.rhyme.headfirst.part1.behavior.FlyBehavior;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public class FlyWithNoWings implements FlyBehavior {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rhyme.headfirst.part1.behavior.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("没有翅膀，不飞也挺好的");
	}

}
