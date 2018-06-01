/**
 *  Created by weiping.gong on 2018年5月18日
 */
package com.rhyme.headfirst.part2;

/**
 * 观察者
 * 
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月18日
 */
public interface Observer {
	// 更新信息
	public void update(float temperatire, float humidity, float pressure);
}
