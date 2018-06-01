/**
 *  Created by weiping.gong on 2018年5月18日
 */
package com.rhyme.headfirst.part2;

/**
 * 主题
 * 
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月18日
 */
public interface Subject {
	// 订阅主题
	public void registerObserver(Observer o);

	// 取消订阅主题
	public void removeObserver(Observer o);

	// 通知所有订阅了主题的人
	public void notifyObservers();
}
