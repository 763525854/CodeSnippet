/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class TestMyThread1 {
	public static void main(String[] args) {
		System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
		MyThread1 thread1=new MyThread1();
		thread1.start();
	}
}
