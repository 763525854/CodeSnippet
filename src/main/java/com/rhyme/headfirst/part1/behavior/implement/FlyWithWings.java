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
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("能飞的感觉真好");
	}

}
