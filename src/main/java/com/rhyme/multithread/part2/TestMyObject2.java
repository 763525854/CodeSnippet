/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class TestMyObject2 {
	public static void main(String[] args) {
		MyObject2 object = new MyObject2();
		ThreadE a = new ThreadE(object);
		a.setName("A");
		ThreadF b = new ThreadF(object);
		b.setName("B");
		a.start();
		b.start();
	}
}
