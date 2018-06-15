/**
 *  Created by weiping.gong on 2018年6月15日
 */
package com.rhyme.multithread.part7;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月15日
 */
public class TimedWaiting {
	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main方法中的状态" + t.getState());
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("begin sleep");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end sleep");
	}
}
