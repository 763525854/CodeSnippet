/**
 *  Created by weiping.gong on 2018年6月15日
 */
package com.rhyme.multithread.part7;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月15日
 */
public class StateTest {
	public static void main(String[] args) {
		try {
			MyThread t = new MyThread();
			System.out.println("main方法中的状态1：" + t.getState());
			Thread.sleep(1000);
			t.start();
			Thread.sleep(1000);
			System.out.println("main方法中的状态2:" + t.getState());
		} catch (Exception e) {
		} finally {
		}
	}
}

class MyThread extends Thread {

	public MyThread() {
		System.out.println("构造方法中的状态:" + Thread.currentThread().getState());
	}

	@Override
	public void run() {
		super.run();
		System.out.println("run方法中的状态:" + Thread.currentThread().getState());
	}
}