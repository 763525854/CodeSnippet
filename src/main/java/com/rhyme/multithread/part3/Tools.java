/**
 *  Created by weiping.gong on 2018年6月11日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月11日
 */
public class Tools {
	public static ThreadLocal t1 = new ThreadLocal<>();

	public static void main(String[] args) {
		ThreadT1 a = new ThreadT1();
		ThreadT2 b = new ThreadT2();
		a.start();
		b.start();
		for (int i = 0; i < 100; i++) {
			Tools.t1.set("Main" + (i + 1));
			System.out.println("main get value=" + Tools.t1.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadT1 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100; i++) {
			Tools.t1.set("ThreadA" + (i + 1));
			System.out.println("ThreadA get Value=" + Tools.t1.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadT2 extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100; i++) {
			Tools.t1.set("ThreadB" + (i + 1));
			System.out.println("ThreadB get value=" + Tools.t1.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}