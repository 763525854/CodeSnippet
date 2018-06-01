/**
 *  Created by weiping.gong on 2018年5月9日
 */
package com.rhyme.headfirst.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月9日
 */
public class TestDouble {
	public static void main(String[] args) {
		double b = 1291;
		double a = 21509;
		int i = (int) (b / a * 100);
		// System.out.println(i);

		double b1 = 0.059999;
		int q = (int) (b1 * 100);
		System.out.println(q);
		double k = Math.round(b1 * 100) / 100.0;
		System.out.println("k is" + k);
		int rate = (int) (Math.round((37600.0 - 35472.0) / 35472.0 * 100) / 100.0 * 100);
		System.out.println(rate);
	}
}
