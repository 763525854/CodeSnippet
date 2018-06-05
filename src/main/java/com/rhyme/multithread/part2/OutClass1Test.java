/**
 *  Created by weiping.gong on 2018年6月5日
 */
package com.rhyme.multithread.part2;

import com.rhyme.multithread.part2.OutClass1.InnerClass1;
import com.rhyme.multithread.part2.OutClass1.InnerClass2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月5日
 */
public class OutClass1Test {
	public static void main(String[] args) {
		final InnerClass1 in1 = new InnerClass1();
		final InnerClass2 in2 = new InnerClass2();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					in1.method1(in2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "T1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				in1.method2();
			}
		}, "T2");
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				in2.method1();

			}
		}, "T3");
		t1.start();
		t2.start();
		t3.start();
	}
}
