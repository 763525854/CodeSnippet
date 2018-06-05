/**
 *  Created by weiping.gong on 2018年6月5日
 */
package com.rhyme.multithread.part2;

import com.rhyme.multithread.part2.OutClass.Inner;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月5日
 */
public class OutClassTest {
	public static void main(String[] args) {
		final Inner inner = new Inner();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				inner.method1();
			}
		}, "A");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				inner.method2();
			}
		}, "B");
		t1.start();
		t2.start();
	}
}
