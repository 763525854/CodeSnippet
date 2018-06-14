/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part6;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class MyObject {
	private static MyObject myObject = new MyObject();

	public MyObject() {

	}

	public static MyObject getInstance() {
		return myObject;
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println(MyObject.getInstance().hashCode());
	}
}
