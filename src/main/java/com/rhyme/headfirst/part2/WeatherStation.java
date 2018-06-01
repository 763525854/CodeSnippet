/**
 *  Created by weiping.gong on 2018年5月18日
 */
package com.rhyme.headfirst.part2;

import java.util.ArrayList;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月18日
 */
public class WeatherStation {
	public static void main(String[] args) {
		// 初始化主题实现
		WeatherData weatherData = new WeatherData();
		// 初始化订阅者
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		// 主题改变
		weatherData.setMeasuremetns(80, 60, 30.4f);
	}
}
