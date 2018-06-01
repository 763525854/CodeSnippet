/**
 *  Created by weiping.gong on 2018年5月18日
 */
package com.rhyme.headfirst.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月18日
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperatire;
	private float humidity;
	private Subject weathData;

	public CurrentConditionsDisplay(Subject weathData) {
		// 订阅主题
		this.weathData = weathData;
		weathData.registerObserver(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rhyme.headfirst.part2.Observer#update(float, float, float)
	 */
	@Override
	public void update(float temperatire, float humidity, float pressure) {
		// 更新主题传递的信息
		this.temperatire = temperatire;
		this.humidity = humidity;
		display();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rhyme.headfirst.part2.DisplayElement#display()
	 */
	@Override
	public void display() {
		// 显示信息
		System.out.println("Current condtitons:  " + temperatire + "F degrees and" + humidity + " %humidity");
	}

}
