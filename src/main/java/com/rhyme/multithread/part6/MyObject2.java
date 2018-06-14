/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part6;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class MyObject2 {
	private static MyObject2 myObject;

	public MyObject2() {
	}

	public static MyObject2 getInstance() {
		if (myObject != null) {
		} else {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			myObject = new MyObject2();
		}
		return myObject;
	}

	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2();
		MyThread2 t2 = new MyThread2();
		MyThread2 t3 = new MyThread2();
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println(MyObject2.getInstance().hashCode());
	}
}
