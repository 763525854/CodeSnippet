/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class TestFastThread {
	public static void main(String[] args) throws InterruptedException {
		FastThread a = new FastThread();
		a.setPriority(Thread.NORM_PRIORITY - 4);
		a.start();
		ThreadB b = new ThreadB();
		b.setPriority(Thread.NORM_PRIORITY + 5);
		b.start();
		Thread.sleep(10000);
		a.stop();
		b.stop();
		System.out.println("a=" + a.getCount());
		System.out.println("b=" + b.getCount());
	}
}
