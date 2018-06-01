/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class TestMyObject {
	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadC a = new ThreadC(object);
		a.setName("A");
		ThreadD b = new ThreadD(object);
		b.setName("B");
		a.start();
		b.start();
	}
}
