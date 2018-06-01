/**
 *  Created by weiping.gong on 2018年5月18日
 */
package com.rhyme.headfirst.part2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 主题的实现
 * 
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月18日
 */
public class WeatherData implements Subject {
	// 存放订阅者的容器
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		// 添加订阅者
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// 移除订阅者。
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		// 循环通知所有订阅的人
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	public void setMeasuremetns(float temperature, float humidity, float pressure) {
		// 设置主题数据
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		// 通知订阅者
		notifyObservers();
	}

}
